package com.ginzo.commons.entities.dto

import android.os.Parcelable
import com.ginzo.commons.entities.Product
import kotlinx.android.parcel.Parcelize

interface ProductDTO : Parcelable

@Parcelize
data class ConsumerGoodsDTO(
  val id: String,
  val image: String,
  val price: String,
  val name: String,
  val description: String,
  val distanceInMeters: Int,
  val color: String,
  val category: String
) : ProductDTO {

  constructor(product: Product.ConsumerGoods) : this(
    product.id,
    product.image,
    product.price,
    product.name,
    product.description,
    product.distanceInMeters,
    product.color,
    product.category
  )

  fun toDomain(): Product.ConsumerGoods {
    return Product.ConsumerGoods(
      id,
      image,
      price,
      name,
      description,
      distanceInMeters,
      color,
      category
    )
  }
}

@Parcelize
data class CarDTO(
  val id: String,
  val image: String,
  val price: String,
  val name: String,
  val description: String,
  val distanceInMeters: Int,
  val motor: String,
  val gearbox: String,
  val brand: String,
  val km: Int
) : ProductDTO {

  constructor(product: Product.Car) : this(
    product.id,
    product.image,
    product.price,
    product.name,
    product.description,
    product.distanceInMeters,
    product.motor,
    product.gearbox,
    product.brand,
    product.km
  )

  fun toDomain(): Product.Car {
    return Product.Car(
      id,
      image,
      price,
      name,
      description,
      distanceInMeters,
      motor,
      gearbox,
      brand,
      km
    )
  }
}

@Parcelize
data class ServiceDTO(
  val id: String,
  val image: String,
  val price: String,
  val name: String,
  val description: String,
  val distanceInMeters: Int,
  val category: String,
  val closeDay: String,
  val minimunAge: Int
) : ProductDTO {

  constructor(product: Product.Service) : this(
    product.id,
    product.image,
    product.price,
    product.name,
    product.description,
    product.distanceInMeters,
    product.category,
    product.closeDay,
    product.minimunAge
  )

  fun toDomain(): Product.Service {
    return Product.Service(
      id,
      image,
      price,
      name,
      description,
      distanceInMeters,
      category,
      closeDay,
      minimunAge
    )
  }
}

fun productToProductDTO(product: Product): ProductDTO {
  return when (product) {
    is Product.ConsumerGoods -> ConsumerGoodsDTO(product)
    is Product.Service -> ServiceDTO(product)
    is Product.Car -> CarDTO(product)
  }
}

fun productDTOToDomain(productDTO: ProductDTO): Product {
  return when (productDTO) {
    is ConsumerGoodsDTO -> productDTO.toDomain()
    is ServiceDTO -> productDTO.toDomain()
    is CarDTO -> productDTO.toDomain()
    else -> throw Exception("Uknown type")
  }
}