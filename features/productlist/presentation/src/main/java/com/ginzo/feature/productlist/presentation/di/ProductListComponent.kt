package com.ginzo.feature.productlist.presentation.di

import com.ginzo.commons.feature_commons.FeatureComponent
import com.ginzo.commons.feature_commons.FeatureScope
import com.ginzo.feature.productlist.data.ProductListDataModule
import com.ginzo.feature.productlist.presentation.ProductListActivity
import com.ginzo.remote.RemoteComponent
import dagger.Component

@FeatureScope
@Component(
  dependencies = [RemoteComponent::class, FeatureComponent::class],
  modules = [ProductListDataModule::class]
)
interface ProductListComponent {
  @Component.Factory
  interface Factory {
    fun create(
      remoteComponent: RemoteComponent,
      featureComponent: FeatureComponent
    ): ProductListComponent
  }

  fun productListActivity(): ProductListActivity.Subcomponent.Factory
}