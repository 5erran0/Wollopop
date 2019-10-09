package com.ginzo.feature.productlist.presentation

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.ginzo.features.productlist.domain.usecases.GetProductsUseCase
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject
import javax.inject.Named

class ProductListPresenter @Inject constructor(
  private val useCase: GetProductsUseCase,
  private val view: ProductListView,
  @Named("main") private val main: Scheduler
) : DefaultLifecycleObserver {

  private val disposable = CompositeDisposable()

  override fun onCreate(owner: LifecycleOwner) {
    view.render(ProductListViewState.Loading)

    disposable.add(
      useCase.getProducts()
        .observeOn(main)
        .subscribe { either ->
          either.fold(
            { view.render(ProductListViewState.Error) },
            { products -> view.render(ProductListViewState.ShownProductList(products)) }
          )
        }
    )
  }

  override fun onDestroy(owner: LifecycleOwner) {
    disposable.dispose()
  }
}