package com.ginzo.features.productlist.domain

import arrow.core.Either
import com.ginzo.features.productlist.domain.entities.Product
import io.reactivex.Single

interface ProductListRepository {
  fun getProducts(): Single<Either<Throwable, List<Product>>>
}