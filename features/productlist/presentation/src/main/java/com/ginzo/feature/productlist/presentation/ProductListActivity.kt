package com.ginzo.feature.productlist.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ginzo.feature.productlist.presentation.di.inject
import dagger.BindsInstance
import kotlinx.android.synthetic.main.activity_product_list.*
import javax.inject.Inject

class ProductListActivity : AppCompatActivity(), ProductListView {

  @Inject
  lateinit var presenter: ProductListPresenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_product_list)

    inject(this)

    lifecycle.addObserver(presenter)
  }

  override fun render(state: ProductListViewState) {
    when (state) {
      is ProductListViewState.Error -> textView.text = "ERROR"
      is ProductListViewState.Loading -> textView.text = "LOADING"
      is ProductListViewState.ShownProductList -> textView.text = state.products.joinToString { it.name }
    }
  }

  @dagger.Subcomponent
  interface Subcomponent {
    @dagger.Subcomponent.Factory
    interface Factory {
      fun create(@BindsInstance view: ProductListView): Subcomponent
    }

    fun inject(activity: ProductListActivity)
  }
}
