package com.ginzo.app

import com.ginzo.app.navigation.DaggerNavigatorComponent
import com.ginzo.app.navigation.NavigatorComponent
import com.ginzo.commons.feature_commons.di.DaggerFeatureComponent
import com.ginzo.commons.feature_commons.di.FeatureComponent
import com.ginzo.feature.productlist.data.DaggerProductListDataComponentImpl
import com.ginzo.feature.productlist.presentation.di.DaggerProductListComponent
import com.ginzo.feature.productlist.presentation.di.ProductListComponent
import com.ginzo.features.productlist.domain.DaggerProductListDomainComponent
import com.ginzo.features.productlist.domain.ProductListDataComponent
import com.ginzo.features.productlist.domain.ProductListDomainComponent
import com.ginzo.remote.DaggerRemoteComponentImpl
import com.ginzo.remote.RemoteComponent

class ComponentManager {

  private val remoteComponent: RemoteComponent by lazy {
    DaggerRemoteComponentImpl.factory().create()
  }

  private val featureComponent: FeatureComponent by lazy {
    DaggerFeatureComponent.factory().create()
  }

  private val navigatorComponent: NavigatorComponent by lazy {
    DaggerNavigatorComponent.factory().create()
  }

  private val productListDataComponent: ProductListDataComponent by lazy {
    DaggerProductListDataComponentImpl.factory().create(remoteComponent)
  }

  private val productListDomainComponent: ProductListDomainComponent by lazy {
    DaggerProductListDomainComponent.factory().create(productListDataComponent)
  }

  val productListComponent: ProductListComponent by lazy {
    DaggerProductListComponent.factory()
      .create(productListDomainComponent, featureComponent, navigatorComponent)
  }
}