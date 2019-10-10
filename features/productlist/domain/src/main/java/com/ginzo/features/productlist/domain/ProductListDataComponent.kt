package com.ginzo.features.productlist.domain

import com.ginzo.features.productlist.domain.repositories.ProductListRepository

interface ProductListDataComponent {
  fun productListRepository(): ProductListRepository
}