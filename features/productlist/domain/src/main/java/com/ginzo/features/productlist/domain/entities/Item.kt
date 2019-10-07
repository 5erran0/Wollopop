package com.ginzo.features.productlist.domain.entities

data class Item(
  val id: String,
  val image: String,
  val price: String,
  val name: String,
  val color: String,
  val category: String,
  val description: String,
  val distanceInMeters: Int
)