package com.ginzo.app

import com.ginzo.commons.feature_commons.di.DaggerFeatureComponent
import com.ginzo.commons.feature_commons.di.FeatureComponent
import com.ginzo.feature.productlist.presentation.di.DaggerProductListComponent
import com.ginzo.feature.productlist.presentation.di.ProductListComponent
import com.ginzo.remote.DaggerRemoteComponent
import com.ginzo.remote.RemoteComponent

class ComponentManager {

  private val remoteComponent: RemoteComponent by lazy {
    DaggerRemoteComponent.factory().create()
  }

  private val featureComponent: FeatureComponent by lazy {
    DaggerFeatureComponent.factory().create()
  }

  val productListComponent: ProductListComponent by lazy {
    DaggerProductListComponent.factory().create(remoteComponent, featureComponent)
  }
}