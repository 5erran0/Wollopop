package com.ginzo.feature.productlist.data.entities

import com.ginzo.commons.data.ToDomain
import com.ginzo.features.productlist.domain.entities.Product
import com.squareup.moshi.JsonClass
import java.io.IOException

@JsonClass(generateAdapter = true)
data class ProductEntity(
  val kind: String,
  val item: ItemEntity
) : ToDomain<Product> {
  override fun toDomain(): Product {
    return when (kind) {
      "car" -> Product.Car(
        item.id,
        item.image,
        item.price,
        item.name,
        item.description,
        item.distanceInMeters,
        item.motor!!,
        item.gearbox!!,
        item.brand!!,
        item.km!!
      )

      "service" -> Product.Service(
        item.id,
        item.image,
        item.price,
        item.name,
        item.description,
        item.distanceInMeters,
        item.category!!,
        item.closeDay!!,
        item.minimunAge!!
      )

      "consumer_goods" -> Product.ConsumerGoods(
        item.id,
        item.image,
        item.price,
        item.name,
        item.description,
        item.distanceInMeters,
        item.color!!,
        item.category!!
      )

      else -> throw IOException("Product type is not recognized")
    }
  }
}