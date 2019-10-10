package com.ginzo.feature.productlist.presentation.di

import com.ginzo.feature.productlist.presentation.ProductListActivity

internal fun inject(activity: ProductListActivity) {
  (activity.application as ProductListComponentProvider).productListComponent
    .productListActivity()
    .create(activity, activity)
    .inject(activity)
}