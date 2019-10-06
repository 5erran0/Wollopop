package com.ginzo.feature.productlist.data

import com.ginzo.feature.productlist.data.api.ProductListApiRest
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
}