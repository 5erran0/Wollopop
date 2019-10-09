package com.ginzo.app

import android.app.Application
import com.ginzo.feature.productlist.presentation.di.ProductListComponent
import com.ginzo.feature.productlist.presentation.di.ProductListComponentProvider

class WollopopApplication : Application(), ProductListComponentProvider {

  private lateinit var componentManager: ComponentManager

  override fun onCreate() {
    super.onCreate()
    componentManager = ComponentManager()
  }

  override val productListComponent: ProductListComponent
    get() = componentManager.productListComponent
}