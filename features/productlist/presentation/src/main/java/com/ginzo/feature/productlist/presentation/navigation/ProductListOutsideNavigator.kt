package com.ginzo.feature.productlist.presentation.navigation

import androidx.appcompat.app.AppCompatActivity

interface ProductListOutsideNavigator {
  fun productDetails()

  interface Factory {
    fun create(activity: AppCompatActivity): ProductListOutsideNavigator
  }
}