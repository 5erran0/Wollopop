package com.ginzo.feature.productlist.presentation

import com.ginzo.feature.productlist.presentation.di.ProductListComponent
import com.nhaarman.mockitokotlin2.mock
import dagger.Component
import dagger.Module
import dagger.Provides

@Component(modules = [MockModule::class])
internal interface MockProductListComponent : ProductListComponent

@Module
internal class MockModule {

  @Provides
  fun productListPresenterProvider(): ProductListPresenter = mock()
}
