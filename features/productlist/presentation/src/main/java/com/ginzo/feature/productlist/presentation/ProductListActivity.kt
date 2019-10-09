package com.ginzo.feature.productlist.presentation

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ginzo.commons.feature_commons.view.bindView
import com.ginzo.feature.productlist.presentation.adapter.ProductListAdapter
import com.ginzo.feature.productlist.presentation.di.inject
import dagger.BindsInstance
import javax.inject.Inject

class ProductListActivity : AppCompatActivity(), ProductListView {

  @Inject
  lateinit var presenter: ProductListPresenter

  private val productList: RecyclerView by bindView(R.id.product_list_recycler_view)
  private val progressBar: ProgressBar by bindView(R.id.product_list_progress_bar)

  private lateinit var productListAdapter: ProductListAdapter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_product_list)

    inject(this)

    productListAdapter = productList.adapter as? ProductListAdapter
      ?: ProductListAdapter(Glide.with(this))

    productList.apply {
      layoutManager = LinearLayoutManager(context)
      adapter = productListAdapter
    }


    lifecycle.addObserver(presenter)
  }

  override fun render(state: ProductListViewState) {
    when (state) {
      is ProductListViewState.Error -> {
        progressBar.visibility = View.GONE
      }
      is ProductListViewState.Loading -> {
        progressBar.visibility = View.VISIBLE
        productList.visibility = View.GONE
      }
      is ProductListViewState.ShownProductList -> {
        progressBar.visibility = View.GONE

        productListAdapter.products = state.products

        productList.visibility = View.VISIBLE
      }
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
