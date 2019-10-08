package com.ginzo.features.productlist.domain.usecases

import arrow.core.Either
import com.ginzo.features.productlist.domain.repositories.ProductListRepository
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.After
import org.junit.Test

class GetProductsUseCaseTest {

  private val repository: ProductListRepository = mock()

  private val usecase = GetProductsUseCase(repository)

  @After
  fun tearDown() {
    verifyNoMoreInteractions(repository)
  }

  @Test
  fun getProducts_ok() {
    whenever(repository.getProducts()).thenReturn(Single.just(Either.right(emptyList())))

    usecase.getProducts()
      .test()
      .assertValue(Either.right(emptyList()))

    verify(repository).getProducts()
  }

  @Test
  fun getProducts_ko() {
    val throwable = Throwable()
    whenever(repository.getProducts()).thenReturn(Single.just(Either.left(throwable)))

    usecase.getProducts()
      .test()
      .assertValue(Either.left(throwable))

    verify(repository).getProducts()
  }
}