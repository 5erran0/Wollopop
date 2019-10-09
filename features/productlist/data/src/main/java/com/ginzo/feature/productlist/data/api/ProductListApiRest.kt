package com.ginzo.feature.productlist.data.api

import com.ginzo.feature.productlist.data.entities.ProductEntity
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface ProductListApiRest {
  @GET("Wallapop/Wallapop-Android-Test-Resources/master/items.json")
  fun getProducts(): Single<Response<List<ProductEntity>>>
}