package com.ginzo.feature.productlist.presentation

import com.ginzo.features.productlist.domain.entities.Product

interface ProductListView {
  fun render(state: ProductListViewState)
}

sealed class ProductListViewState {
  object Loading : ProductListViewState()
  object Error : ProductListViewState()
  data class ShownProductList(val products: List<Product>) : ProductListViewState()
}