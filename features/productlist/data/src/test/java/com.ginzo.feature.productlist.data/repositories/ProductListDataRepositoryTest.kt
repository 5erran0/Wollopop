package com.ginzo.feature.productlist.data.repositories

import arrow.core.Either
import com.ginzo.commons.entities.Product
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.After
import org.junit.Test

class ProductListDataRepositoryTest {
  private val apiRepository: ProductListApiRepository = mock()

  private val dataRepository = ProductListDataRepository(apiRepository)

  private val productListWithReps = listOf(
    com.ginzo.commons.entities.Product.ConsumerGoods(
      id = "5a7ab3e09798181675dc1751",
      image = "https://raw.githubusercontent.com/Wallapop/Wallapop-Android-Test-Resources/master/images/image9.jpg",
      price = "447€",
      name = "enim",
      color = "orange",
      category = "children",
      description = "Officia excepteur exercitation laborum cillum occaecat Lorem voluptate ad ullamco adipisicing adipisicing amet non. Dolor exercitation laborum sunt in ex elit officia non labore veniam culpa dolore. Ex ex tempor anim non.",
      distanceInMeters = 414
    ),
    com.ginzo.commons.entities.Product.ConsumerGoods(
      id = "sdasreasefadadas",
      image = "https://raw.githubusercontent.com/Wallapop/Wallapop-Android-Test-Resources/master/images/image15.jpg",
      price = "447€",
      name = "enim",
      color = "orange",
      category = "children",
      description = "Officia excepteur exercitation laborum cillum occaecat Lorem voluptate ad ullamco adipisicing adipisicing amet non. Dolor exercitation laborum sunt in ex elit officia non labore veniam culpa dolore. Ex ex tempor anim non.",
      distanceInMeters = 14
    ),
    com.ginzo.commons.entities.Product.ConsumerGoods(
      id = "5a7ab3e09798181675dc1751",
      image = "https://raw.githubusercontent.com/Wallapop/Wallapop-Android-Test-Resources/master/images/image9.jpg",
      price = "447€",
      name = "enim",
      color = "orange",
      category = "children",
      description = "Officia excepteur exercitation laborum cillum occaecat Lorem voluptate ad ullamco adipisicing adipisicing amet non. Dolor exercitation laborum sunt in ex elit officia non labore veniam culpa dolore. Ex ex tempor anim non.",
      distanceInMeters = 414
    )
  )

  private val productList = listOf(
    com.ginzo.commons.entities.Product.ConsumerGoods(
      id = "sdasreasefadadas",
      image = "https://raw.githubusercontent.com/Wallapop/Wallapop-Android-Test-Resources/master/images/image15.jpg",
      price = "447€",
      name = "enim",
      color = "orange",
      category = "children",
      description = "Officia excepteur exercitation laborum cillum occaecat Lorem voluptate ad ullamco adipisicing adipisicing amet non. Dolor exercitation laborum sunt in ex elit officia non labore veniam culpa dolore. Ex ex tempor anim non.",
      distanceInMeters = 14
    ),
    com.ginzo.commons.entities.Product.ConsumerGoods(
      id = "5a7ab3e09798181675dc1751",
      image = "https://raw.githubusercontent.com/Wallapop/Wallapop-Android-Test-Resources/master/images/image9.jpg",
      price = "447€",
      name = "enim",
      color = "orange",
      category = "children",
      description = "Officia excepteur exercitation laborum cillum occaecat Lorem voluptate ad ullamco adipisicing adipisicing amet non. Dolor exercitation laborum sunt in ex elit officia non labore veniam culpa dolore. Ex ex tempor anim non.",
      distanceInMeters = 414
    )
  )

  @After
  fun tearDown() {
    verifyNoMoreInteractions(apiRepository)
  }

  @Test
  fun getProducts_ok() {
    whenever(apiRepository.products()).thenReturn(Single.just(Either.right(productListWithReps)))

    dataRepository.getProducts()
      .test()
      .assertValue(Either.right(productList))

    verify(apiRepository).products()
  }

  @Test
  fun getProducts_ko() {
    val throwable = Throwable()
    whenever(apiRepository.products()).thenReturn(Single.just(Either.left(throwable)))

    dataRepository.getProducts()
      .test()
      .assertValue(Either.left(throwable))

    verify(apiRepository).products()
  }

}