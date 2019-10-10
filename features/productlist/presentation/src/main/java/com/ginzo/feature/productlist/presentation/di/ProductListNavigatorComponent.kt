package com.ginzo.feature.productlist.presentation.di

import com.ginzo.feature.productlist.presentation.navigation.ProductListOutsideNavigator

interface ProductListNavigatorComponent {
  fun productListOutsideNavigatorFactory(): ProductListOutsideNavigator.Factory
}