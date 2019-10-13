package com.ginzo.feature.productlist.data.repositories

import arrow.core.Either
import com.ginzo.commons.feature_commons.test.OpenClass
import com.ginzo.feature.productlist.data.api.ProductListApiRest
import com.ginzo.remote.responseToEither
import io.reactivex.Single
import javax.inject.Inject

@OpenClass
class ProductListApiRepository @Inject constructor(
  private val apiRest: ProductListApiRest
) {
  fun products(): Single<Either<Throwable, List<com.ginzo.commons.entities.Product>>> {
    return apiRest.getProducts()
      .compose(responseToEither { productList ->
        productList.map { it.toDomain() }
      })
  }
}