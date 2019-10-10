package com.ginzo.app.navigation

import com.ginzo.feature.productlist.presentation.di.ProductListNavigatorComponent
import dagger.Component

@Component(modules = [NavigatorModule::class])
interface NavigatorComponent : ProductListNavigatorComponent {
  @Component.Factory
  interface Factory {
    fun create(): NavigatorComponent
  }
}