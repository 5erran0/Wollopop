package com.ginzo.feature.productlist.data.entities

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ItemEntity(
    val id: String,
    val image: String,
    val price: String,
    val name: String,
    val color: String,
    val category: String,
    val description: String,
    val distanceInMeters: Int
)