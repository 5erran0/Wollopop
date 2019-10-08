package com.ginzo.features.productlist.domain.usecases

import arrow.core.Either
import com.ginzo.features.productlist.domain.entities.Product
import com.ginzo.features.productlist.domain.repositories.ProductListRepository
import io.reactivex.Single
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
  private val repository: ProductListRepository
) {

  fun getProducts(): Single<Either<Throwable, List<Product>>> {
    return repository.getProducts()
  }
}