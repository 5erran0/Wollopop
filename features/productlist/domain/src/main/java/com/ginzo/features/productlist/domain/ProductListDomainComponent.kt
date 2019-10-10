package com.ginzo.features.productlist.domain

import com.ginzo.features.productlist.domain.usecases.GetProductsUseCase
import dagger.Component

@Component(dependencies = [ProductListDataComponent::class])
interface ProductListDomainComponent {
  @Component.Factory
  interface Factory {
    fun create(productListDataComponent: ProductListDataComponent): ProductListDomainComponent
  }

  fun getProductsUseCase(): GetProductsUseCase
}