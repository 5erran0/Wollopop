package com.ginzo.feature.productlist.data

import com.ginzo.features.productlist.domain.ProductListDataComponent
import com.ginzo.remote.RemoteComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
  dependencies = [RemoteComponent::class],
  modules = [ProductListDataModule::class]
)
interface ProductListDataComponentImpl : ProductListDataComponent {
  @Component.Factory
  interface Factory {
    fun create(remoteComponent: RemoteComponent): ProductListDataComponent
  }
}