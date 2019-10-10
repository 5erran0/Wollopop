package com.ginzo.feature.productlist.presentation

import com.ginzo.features.productlist.domain.entities.Product
import io.reactivex.Observable

interface ProductListView {
  fun render(state: ProductListViewState)
  val userIntents: Observable<ProductListUserIntents>
}

sealed class ProductListViewState {
  object Loading : ProductListViewState()
  object Error : ProductListViewState()
  data class ShownProductList(val products: List<Product>) : ProductListViewState()
}

sealed class ProductListUserIntents {
  data class ClickProduct(val product: Product) : ProductListUserIntents()
  object Retry : ProductListUserIntents()
}