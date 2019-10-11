package com.ginzo.app.navigation

import com.ginzo.commons.entities.Product

interface Navigator {
  fun productDetail(product: Product)
}