package com.ginzo.feature.productlist.presentation

import android.app.Application
import com.ginzo.feature.productlist.presentation.di.ProductListComponent
import com.ginzo.feature.productlist.presentation.di.ProductListComponentProvider

class MockApp : Application(), ProductListComponentProvider {
  override val productListComponent: ProductListComponent
    get() = DaggerMockProductListComponent.create()
}