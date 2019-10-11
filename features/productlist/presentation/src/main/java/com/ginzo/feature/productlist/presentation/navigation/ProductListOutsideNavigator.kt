package com.ginzo.feature.productlist.presentation.navigation

import androidx.appcompat.app.AppCompatActivity
import com.ginzo.commons.entities.Product

interface ProductListOutsideNavigator {
  fun productDetails(product: Product)

  interface Factory {
    fun create(activity: AppCompatActivity): ProductListOutsideNavigator
  }
}