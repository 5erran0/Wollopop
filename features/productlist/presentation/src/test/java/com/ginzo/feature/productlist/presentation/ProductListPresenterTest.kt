package com.ginzo.feature.productlist.presentation

import androidx.lifecycle.LifecycleOwner
import arrow.core.Either
import com.ginzo.feature.productlist.presentation.navigation.ProductListOutsideNavigator
import com.ginzo.features.productlist.domain.usecases.GetProductsUseCase
import com.jakewharton.rxrelay2.PublishRelay
import com.jakewharton.rxrelay2.Relay
import com.nhaarman.mockitokotlin2.*
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.junit.After
import org.junit.Test

class ProductListPresenterTest {
  private val useCase: GetProductsUseCase = mock()
  private val outsideNavigator: ProductListOutsideNavigator = mock()

  private val userIntents: Relay<ProductListUserIntents> = PublishRelay.create()
  private val view: ProductListView = mock {
    on { userIntents } doReturn userIntents
  }

  private val owner: LifecycleOwner = mock()

  private val presenter = ProductListPresenter(useCase, view, Schedulers.trampoline(), outsideNavigator)

  @After
  fun tearDown() {
    verifyNoMoreInteractions(useCase, view, outsideNavigator)
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

  @Test
  fun userIntentRetry() {
    whenever(useCase.getProducts()).thenReturn(Single.just(Either.right(emptyList())))

    userIntents.accept(ProductListUserIntents.Retry)

    verify(view).render(ProductListViewState.Loading)
    verify(useCase).getProducts()
    verify(view).render(ProductListViewState.ShownProductList(emptyList()))
  }

  @Test
  fun userIntentClickProduct() {
    userIntents.accept(ProductListUserIntents.Retry)

    verify(outsideNavigator).productDetails()
  }
}