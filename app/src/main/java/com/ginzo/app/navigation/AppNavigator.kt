package com.ginzo.app.navigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
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

  override fun productDetail() {
    activity.startActivity(
      Intent(Intent.ACTION_VIEW)
        .setClass(activity, ProductDetailActivity::class.java)
    )
  }
}