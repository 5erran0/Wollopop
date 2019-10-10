package com.ginzo.feature.productlist.presentation

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.ginzo.commons.feature_commons.test.OpenClass
import com.ginzo.feature.productlist.presentation.navigation.ProductListOutsideNavigator
import com.ginzo.features.productlist.domain.usecases.GetProductsUseCase
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject
import javax.inject.Named

@OpenClass
class ProductListPresenter @Inject constructor(
  private val useCase: GetProductsUseCase,
  private val view: ProductListView,
  @Named("main") private val main: Scheduler,
  private val outsideNavigator: ProductListOutsideNavigator
) : DefaultLifecycleObserver {

  private val disposable = CompositeDisposable()

  override fun onCreate(owner: LifecycleOwner) {
    getProductList()

    disposable.add(
      view.userIntents
        .subscribe {
          when (it) {
            is ProductListUserIntents.ClickProduct -> outsideNavigator.productDetails()
            is ProductListUserIntents.Retry -> getProductList()
          }
        }
    )
  }

  private fun getProductList() {
    disposable.add(
      useCase.getProducts()
        .map { either ->
          either.fold(
            { ProductListViewState.Error },
            { products -> ProductListViewState.ShownProductList(products) }
          )
        }
        .toFlowable()
        .observeOn(main)
        .startWith(ProductListViewState.Loading)
        .subscribe(view::render)
    )
  }

  override fun onDestroy(owner: LifecycleOwner) {
    disposable.dispose()
  }
}