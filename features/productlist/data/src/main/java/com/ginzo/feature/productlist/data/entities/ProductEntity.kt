package com.ginzo.feature.productlist.data.entities

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProductEntity(
    val kind: String,
    val item: ItemEntity
)