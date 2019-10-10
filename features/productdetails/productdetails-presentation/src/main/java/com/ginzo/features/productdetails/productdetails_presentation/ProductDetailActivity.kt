package com.ginzo.features.productdetails.productdetails_presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.ginzo.commons.feature_commons.view.bindView

class ProductDetailActivity : AppCompatActivity() {

  private val toolbar: Toolbar by bindView(R.id.product_detail_toolbar)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_product_detail)

    toolbar.setNavigationOnClickListener { onBackPressed() }
  }
}
