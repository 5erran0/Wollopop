package com.ginzo.app.di

import com.ginzo.feature.productlist.data.DaggerProductListDataComponent
import com.ginzo.feature.productlist.data.ProductListDataComponent
import com.ginzo.remote.DaggerRemoteComponent
import com.ginzo.remote.RemoteComponent

class ComponentManager() {

  val remoteComponent: RemoteComponent by lazy {
    DaggerRemoteComponent.factory().create()
  }

  val productListDataComponent: ProductListDataComponent by lazy {
    DaggerProductListDataComponent.factory().create(remoteComponent)
  }
}