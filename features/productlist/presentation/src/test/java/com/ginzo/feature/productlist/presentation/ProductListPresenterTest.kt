package com.ginzo.feature.productlist.presentation

import androidx.lifecycle.LifecycleOwner
import arrow.core.Either
import com.ginzo.features.productlist.domain.usecases.GetProductsUseCase
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.junit.After
import org.junit.Test

class ProductListPresenterTest {
  private val useCase: GetProductsUseCase = mock()
  private val view: ProductListView = mock()

  private val owner: LifecycleOwner = mock()

  private val presenter = ProductListPresenter(useCase, view, Schedulers.trampoline())

  @After
  fun tearDown() {
    verifyNoMoreInteractions(useCase, view)
  }

  @Test
  fun onCreate_ok() {
    whenever(useCase.getProducts()).thenReturn(Single.just(Either.right(emptyList())))

    presenter.onCreate(owner)

    verify(view).render(ProductListViewState.Loading)
    verify(useCase).getProducts()
    verify(view).render(ProductListViewState.ShownProductList(emptyList()))
  }

  @Test
  fun onCreate_ko() {
    val throwable = Throwable()
    whenever(useCase.getProducts()).thenReturn(Single.just(Either.left(throwable)))

    presenter.onCreate(owner)

    verify(view).render(ProductListViewState.Loading)
    verify(useCase).getProducts()
    verify(view).render(ProductListViewState.Error)
  }
}