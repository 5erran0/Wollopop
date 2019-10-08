package com.ginzo.feature.productlist.data

import com.ginzo.feature.productlist.data.api.ProductListApiRest
import com.ginzo.feature.productlist.data.repositories.ProductListDataRepository
import com.ginzo.features.productlist.domain.repositories.ProductListRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
abstract class ProductListDataModule {

  @Module
  companion object {
    @Provides
    @JvmStatic
    internal fun providesProductListApiRest(retrofit: Retrofit): ProductListApiRest {
      return retrofit.create(ProductListApiRest::class.java)
    }
  }

  @Binds
  abstract fun productListrepository(repository: ProductListDataRepository): ProductListRepository
}