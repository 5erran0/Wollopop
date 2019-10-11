package com.ginzo.feature.productlist.presentation

import androidx.lifecycle.LifecycleOwner
import arrow.core.Either
import com.ginzo.commons.entities.Product
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

  private val presenter =
    ProductListPresenter(useCase, view, Schedulers.trampoline(), outsideNavigator)

  @After
  fun tearDown() {
    verifyNoMoreInteractions(useCase, outsideNavigator)
  }

  @Test
  fun onCreate_ok() {
    whenever(useCase.getProducts()).thenReturn(Single.just(Either.right(emptyList())))

    presenter.onCreate(owner)

    verify(view).userIntents

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
    verify(view).userIntents
    verify(useCase).getProducts()
    verify(view).render(ProductListViewState.Error)
  }

  @Test
  fun userIntentRetry() {
    val throwable = Throwable()
    whenever(useCase.getProducts()).thenReturn(Single.just(Either.left(throwable)))

    presenter.onCreate(owner)
    userIntents.accept(ProductListUserIntents.Retry)

    verify(view).userIntents

    verify(view, times(2)).render(ProductListViewState.Loading)
    verify(useCase, times(2)).getProducts()
    verify(view, times(2)).render(ProductListViewState.Error)
  }

  @Test
  fun userIntentClickProduct() {
    val product = Product.Car(
      id = "5a7ab5108d12300142fae4a7",
      image = "https://raw.githubusercontent.com/Wallapop/Wallapop-Android-Test-Resources/master/images/image6.jpg",
      price = "354076€",
      name = "duis",
      motor = "gasoline",
      gearbox = "manual",
      brand = "irure",
      km = 1341,
      description = "Ad eiusmod consectetur nisi enim ex laborum duis adipisicing consectetur pariatur culpa minim. Aliqua quis proident tempor exercitation commodo nisi excepteur quis laborum eu nulla. Irure proident eiusmod nulla ea ut mollit ullamco ea reprehenderit nisi quis id ad et.",
      distanceInMeters = 841
    )

    whenever(useCase.getProducts()).thenReturn(Single.just(Either.right(emptyList())))

    presenter.onCreate(owner)

    verify(view).userIntents

    verify(view).render(ProductListViewState.Loading)
    verify(useCase).getProducts()
    verify(view).render(ProductListViewState.ShownProductList(emptyList()))

    userIntents.accept(ProductListUserIntents.ClickProduct(product))

    verify(outsideNavigator).productDetails(product)
  }
}