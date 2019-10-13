package com.ginzo.features.productlist.domain.repositories

import arrow.core.Either
import io.reactivex.Single

interface ProductListRepository {
  fun getProducts(): Single<Either<Throwable, List<com.ginzo.commons.entities.Product>>>
}