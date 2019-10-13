package com.ginzo.feature.productlist.presentation.di

import com.ginzo.commons.feature_commons.di.FeatureComponent
import com.ginzo.feature.productlist.presentation.ProductListActivity
import com.ginzo.features.productlist.domain.ProductListDomainComponent
import dagger.Component

@Component(
  dependencies = [ProductListDomainComponent::class, FeatureComponent::class, ProductListNavigatorComponent::class]
)
interface ProductListComponent {
  @Component.Factory
  interface Factory {
    fun create(
      productListDomainComponent: ProductListDomainComponent,
      featureComponent: FeatureComponent,
      productListNavigatorComponent: ProductListNavigatorComponent
    ): ProductListComponent
  }

  fun productListActivity(): ProductListActivity.Subcomponent.Factory
}