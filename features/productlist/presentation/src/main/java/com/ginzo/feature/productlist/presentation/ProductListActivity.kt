package com.ginzo.feature.productlist.presentation

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ginzo.commons.feature_commons.view.bindView
import com.ginzo.feature.productlist.presentation.adapter.ProductListAdapter
import com.ginzo.feature.productlist.presentation.di.ProductListNavigatorModule
import com.ginzo.feature.productlist.presentation.di.inject
import com.jakewharton.rxbinding3.view.clicks
import com.jakewharton.rxrelay2.PublishRelay
import com.jakewharton.rxrelay2.Relay
import dagger.BindsInstance
import io.reactivex.Observable
import javax.inject.Inject

class ProductListActivity : AppCompatActivity(), ProductListView {

  @Inject
  lateinit var presenter: ProductListPresenter

  private val productList: RecyclerView by bindView(R.id.product_list_recycler_view)
  private val progressBar: ProgressBar by bindView(R.id.product_list_progress_bar)
  private val retry: LinearLayout by bindView(R.id.ll_product_list_retry)

  private lateinit var productListAdapter: ProductListAdapter

  private val eventsRelay: Relay<ProductListUserIntents> = PublishRelay.create()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_product_list)

    inject(this)

    productListAdapter = productList.adapter as? ProductListAdapter
      ?: ProductListAdapter(Glide.with(this)) {
        eventsRelay.accept(
          ProductListUserIntents.ClickProduct(
            it
          )
        )
      }

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
        productList.visibility = View.GONE
        retry.visibility = View.VISIBLE
      }
      is ProductListViewState.Loading -> {
        progressBar.visibility = View.VISIBLE
        productList.visibility = View.GONE
        retry.visibility = View.GONE
      }
      is ProductListViewState.ShownProductList -> {
        progressBar.visibility = View.GONE
        retry.visibility = View.GONE

        productListAdapter.products = state.products

        productList.visibility = View.VISIBLE
      }
    }
  }

  override val userIntents: Observable<ProductListUserIntents>
    get() = Observable.merge(
      eventsRelay,
      retry.clicks().map { ProductListUserIntents.Retry })

  @dagger.Subcomponent(modules = [ProductListNavigatorModule::class])
  interface Subcomponent {
    @dagger.Subcomponent.Factory
    interface Factory {
      fun create(
        @BindsInstance view: ProductListView,
        @BindsInstance activity: AppCompatActivity
      ): Subcomponent
    }

    fun inject(activity: ProductListActivity)
  }
}
