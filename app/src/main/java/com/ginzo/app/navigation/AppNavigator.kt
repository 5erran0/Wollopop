package com.ginzo.app.navigation

import androidx.appcompat.app.AppCompatActivity
import com.ginzo.commons.entities.Product
import com.ginzo.features.productdetails.productdetails_presentation.ProductDetailActivity
import javax.inject.Inject

class AppNavigator constructor(
  private val activity: AppCompatActivity
) : Navigator {

  class Factory @Inject constructor() {
    fun create(activity: AppCompatActivity): Navigator {
      return AppNavigator(activity)
    }
  }

  override fun productDetail(product: Product) {
    activity.startActivity(
      ProductDetailActivity.getCallingIntent(activity, product)
    )
  }
}