package com.ginzo.features.productlist.domain.entities

sealed class Product {
  abstract val id: String
  abstract val image: String
  abstract val price: String
  abstract val name: String
  abstract val description: String
  abstract val distanceInMeters: Int

  data class ConsumerGoods(
    override val id: String,
    override val image: String,
    override val price: String,
    override val name: String,
    override val description: String,
    override val distanceInMeters: Int,
    val color: String,
    val category: String
  ) : Product()

  data class Car(
    override val id: String,
    override val image: String,
    override val price: String,
    override val name: String,
    override val description: String,
    override val distanceInMeters: Int,
    val motor: String,
    val gearbox: String,
    val brand: String,
    val km: Int
  ) : Product()

  data class Service(
    override val id: String,
    override val image: String,
    override val price: String,
    override val name: String,
    override val description: String,
    override val distanceInMeters: Int,
    val category: String,
    val closeDay: String,
    val minimunAge: Int
  ) : Product()
}