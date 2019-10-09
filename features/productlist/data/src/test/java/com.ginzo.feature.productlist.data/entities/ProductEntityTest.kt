package com.ginzo.feature.productlist.data.entities

import com.ginzo.features.productlist.domain.entities.Product
import com.squareup.moshi.Moshi
import okio.Okio
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.IOException

class ProductEntityTest {
  private val moshi: Moshi = Moshi.Builder().build()
  private val jsonAdapter = moshi.adapter<ProductEntity>(ProductEntity::class.java)

  @Test
  fun toDomain_ConsumerGoods() {
    val reader =
      Okio.buffer(Okio.source(javaClass.classLoader!!.getResourceAsStream("json/product_consumer_goods.json")!!))
    val item = jsonAdapter.fromJson(reader)!!.toDomain()

    assertEquals(
      Product.ConsumerGoods(
        id = "5a7ab3e09798181675dc1751",
        image = "https://raw.githubusercontent.com/Wallapop/Wallapop-Android-Test-Resources/master/images/image9.jpg",
        price = "447€",
        name = "enim",
        color = "orange",
        category = "children",
        description = "Officia excepteur exercitation laborum cillum occaecat Lorem voluptate ad ullamco adipisicing adipisicing amet non. Dolor exercitation laborum sunt in ex elit officia non labore veniam culpa dolore. Ex ex tempor anim non.",
        distanceInMeters = 414
      ),
      item
    )
  }

  @Test
  fun toDomain_Car() {
    val reader =
      Okio.buffer(Okio.source(javaClass.classLoader!!.getResourceAsStream("json/product_car.json")!!))
    val item = jsonAdapter.fromJson(reader)!!.toDomain()

    assertEquals(
      Product.Car(
        id = "5a7ab5108d12300142fae4a7",
        image = "https://raw.githubusercontent.com/Wallapop/Wallapop-Android-Test-Resources/master/images/image6.jpg",
        price = "354076€",
        name = "duis",
        motor = "gasoline",
        gearbox = "manual",
        brand = "irure",
        km = 1341,
        description = "Ad eiusmod consectetur nisi enim ex laborum duis adipisicing consectetur pariatur culpa minim. Aliqua quis proident tempor exercitation commodo nisi excepteur quis laborum eu nulla. Irure proident eiusmod nulla ea ut mollit ullamco ea reprehenderit nisi quis id ad et.",
        distanceInMeters = 841
      ),
      item
    )
  }

  @Test
  fun toDomain_Service() {
    val reader =
      Okio.buffer(Okio.source(javaClass.classLoader!!.getResourceAsStream("json/product_service.json")!!))
    val item = jsonAdapter.fromJson(reader)!!.toDomain()

    assertEquals(
      Product.Service(
        id = "5a7abb02dcbccd9bb8e9fb88",
        image = "https://raw.githubusercontent.com/Wallapop/Wallapop-Android-Test-Resources/master/images/image8.jpg",
        price = "185€",
        name = "ex",
        closeDay = "monday",
        category = "sport",
        minimunAge = 14,
        description = "Do irure labore pariatur labore do eiusmod ea sunt duis. Commodo enim incididunt cillum veniam enim magna aute reprehenderit adipisicing sit in consequat. Proident tempor id ut cillum exercitation consequat tempor eiusmod. Elit nisi mollit ipsum qui quis Lorem tempor reprehenderit Lorem adipisicing commodo ad. Mollit sunt culpa eiusmod cupidatat consectetur et nostrud reprehenderit enim duis dolor.",
        distanceInMeters = 736
      ),
      item
    )
  }

  @Test
  fun toDomain_Unknown() {
    try {
      val reader = Okio.buffer(Okio.source(javaClass.classLoader!!.getResourceAsStream("json/product_unknown_type.json")!!))
      jsonAdapter.fromJson(reader)!!.toDomain()

      Assert.fail()
    } catch (e: IOException) {
      // no-op
    }
  }

}