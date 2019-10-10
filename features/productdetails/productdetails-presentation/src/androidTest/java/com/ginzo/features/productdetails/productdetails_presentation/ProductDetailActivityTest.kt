package com.ginzo.features.productdetails.productdetails_presentation

import android.content.Context
import android.content.Intent
import androidx.test.core.app.ApplicationProvider
import androidx.test.rule.ActivityTestRule
import org.junit.Before
import org.junit.Rule

class ProductDetailActivityTest {
  private val context = ApplicationProvider.getApplicationContext<Context>()

  @Rule
  @JvmField
  val activityRule = ActivityTestRule(ProductDetailActivity::class.java)

  private val activity: ProductDetailActivity
    get() = activityRule.activity

  private fun runOnUiThread(runnable: () -> Unit) {
    activity.runOnUiThread(runnable)
  }

  @Before
  fun init() {
    activityRule.launchActivity(Intent(context, ProductDetailActivity::class.java))
  }
}
