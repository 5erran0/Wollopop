package com.ginzo.feature.productlist.presentation.di

import androidx.appcompat.app.AppCompatActivity
import com.ginzo.feature.productlist.presentation.navigation.ProductListOutsideNavigator
import dagger.Module
import dagger.Provides

@Module
class ProductListNavigatorModule {

  @Module
  companion object {
    @Provides
    @JvmStatic
    fun providesProductListOutsideNavigator(
      activity: AppCompatActivity,
      factory: ProductListOutsideNavigator.Factory
    ): ProductListOutsideNavigator {
      return factory.create(activity)
    }
  }

}