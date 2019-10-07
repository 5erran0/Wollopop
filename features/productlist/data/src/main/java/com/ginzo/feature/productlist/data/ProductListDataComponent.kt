package com.ginzo.feature.productlist.data

import com.ginzo.remote.RemoteComponent
import dagger.Component

@ProductListDataScope
@Component(
  modules = [ProductListDataModule::class],
  dependencies = [RemoteComponent::class]
)
interface ProductListDataComponent {
  @Component.Factory
  interface Factory {
    fun create(
      remoteComponent: RemoteComponent
    ): ProductListDataComponent
  }
}