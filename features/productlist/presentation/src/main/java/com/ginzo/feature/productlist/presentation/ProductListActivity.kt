package com.ginzo.feature.productlist.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ProductListActivity : AppCompatActivity(), ProductListView {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_product_list)
  }

  override fun render(state: ProductListViewState) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }
}
