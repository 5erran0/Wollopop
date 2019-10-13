package com.ginzo.feature.productlist.presentation

import io.reactivex.Observable

interface ProductListView {
  fun render(state: ProductListViewState)
  val userIntents: Observable<ProductListUserIntents>
}

sealed class ProductListViewState {
  object Loading : ProductListViewState()
  object Error : ProductListViewState()
  data class ShownProductList(val products: List<com.ginzo.commons.entities.Product>) :
    ProductListViewState()
}

sealed class ProductListUserIntents {
  data class ClickProduct(val product: com.ginzo.commons.entities.Product) :
    ProductListUserIntents()

  object Retry : ProductListUserIntents()
}