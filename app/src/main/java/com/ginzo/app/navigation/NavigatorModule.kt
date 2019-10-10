package com.ginzo.app.navigation

import androidx.appcompat.app.AppCompatActivity
import com.ginzo.feature.productlist.presentation.navigation.ProductListOutsideNavigator
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class NavigatorModule {

  @Module
  companion object {
    @Provides
    @JvmStatic
    fun providesNavigatorFactory(
      activity: AppCompatActivity,
      factory: AppNavigator.Factory
    ): Navigator {
      return factory.create(activity)
    }
  }

  @Binds
  abstract fun controlPanelNavigator(factory: ProductListOutsideNavigatorImpl.Factory): ProductListOutsideNavigator.Factory
}