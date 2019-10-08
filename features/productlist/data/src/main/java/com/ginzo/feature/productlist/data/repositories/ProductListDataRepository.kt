package com.ginzo.feature.productlist.data.repositories

import arrow.core.Either
import com.ginzo.features.productlist.domain.repositories.ProductListRepository
import com.ginzo.features.productlist.domain.entities.Product
import io.reactivex.Single
import javax.inject.Inject

class ProductListDataRepository @Inject constructor(
  private val apiRepository: ProductListApiRepository
) : ProductListRepository {
  override fun getProducts(): Single<Either<Throwable, List<Product>>> {
    return apiRepository.products()
      .map { either ->
        either.map { products ->
          products
            .sortedBy { it.distanceInMeters }
            .distinctBy { it.id }
        }
      }
  }
}