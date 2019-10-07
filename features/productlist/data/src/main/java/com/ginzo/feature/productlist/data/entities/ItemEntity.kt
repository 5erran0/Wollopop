package com.ginzo.feature.productlist.data.entities

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ItemEntity(
	val id: String,
	val image: String,
	val price: String,
	val name: String,
	val description: String,
	val distanceInMeters: Int,
	val color: String?,
	val category: String?,
	val motor: String?,
	val gearbox: String?,
	val brand: String?,
	val km: Int?,
	val closeDay: String?,
	val minimunAge: Int?
)