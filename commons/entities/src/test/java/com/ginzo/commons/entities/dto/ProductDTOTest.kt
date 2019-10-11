package com.ginzo.commons.entities.dto

import com.ginzo.commons.entities.Product
import org.junit.Assert.assertEquals
import org.junit.Test

class ProductDTOTest {

  private val consumerGoods = Product.ConsumerGoods(
    id = "5a7ab3e09798181675dc1751",
    image = "https://raw.githubusercontent.com/Wallapop/Wallapop-Android-Test-Resources/master/images/image9.jpg",
    price = "447€",
    name = "enim",
    color = "orange",
    category = "children",
    description = "Officia excepteur exercitation laborum cillum occaecat Lorem voluptate ad ullamco adipisicing adipisicing amet non. Dolor exercitation laborum sunt in ex elit officia non labore veniam culpa dolore. Ex ex tempor anim non.",
    distanceInMeters = 414
  )

  private val service = Product.Service(
    id = "5a7abb02dcbccd9bb8e9fb88",
    image = "https://raw.githubusercontent.com/Wallapop/Wallapop-Android-Test-Resources/master/images/image8.jpg",
    price = "185€",
    name = "ex",
    closeDay = "monday",
    category = "sport",
    minimunAge = 14,
    description = "Do irure labore pariatur labore do eiusmod ea sunt duis. Commodo enim incididunt cillum veniam enim magna aute reprehenderit adipisicing sit in consequat. Proident tempor id ut cillum exercitation consequat tempor eiusmod. Elit nisi mollit ipsum qui quis Lorem tempor reprehenderit Lorem adipisicing commodo ad. Mollit sunt culpa eiusmod cupidatat consectetur et nostrud reprehenderit enim duis dolor.",
    distanceInMeters = 736
  )

  private val car = Product.Car(
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
  )

  private val consumerGoodsDTO = ConsumerGoodsDTO(
    id = "5a7ab3e09798181675dc1751",
    image = "https://raw.githubusercontent.com/Wallapop/Wallapop-Android-Test-Resources/master/images/image9.jpg",
    price = "447€",
    name = "enim",
    color = "orange",
    category = "children",
    description = "Officia excepteur exercitation laborum cillum occaecat Lorem voluptate ad ullamco adipisicing adipisicing amet non. Dolor exercitation laborum sunt in ex elit officia non labore veniam culpa dolore. Ex ex tempor anim non.",
    distanceInMeters = 414
  )

  private val serviceDTO = ServiceDTO(
    id = "5a7abb02dcbccd9bb8e9fb88",
    image = "https://raw.githubusercontent.com/Wallapop/Wallapop-Android-Test-Resources/master/images/image8.jpg",
    price = "185€",
    name = "ex",
    closeDay = "monday",
    category = "sport",
    minimunAge = 14,
    description = "Do irure labore pariatur labore do eiusmod ea sunt duis. Commodo enim incididunt cillum veniam enim magna aute reprehenderit adipisicing sit in consequat. Proident tempor id ut cillum exercitation consequat tempor eiusmod. Elit nisi mollit ipsum qui quis Lorem tempor reprehenderit Lorem adipisicing commodo ad. Mollit sunt culpa eiusmod cupidatat consectetur et nostrud reprehenderit enim duis dolor.",
    distanceInMeters = 736
  )

  private val carDTO = CarDTO(
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
  )

  @Test
  fun consumerGoodsToDomain() {
    assertEquals(consumerGoods, consumerGoodsDTO.toDomain())
  }

  @Test
  fun serviceToDomain() {
    assertEquals(service, serviceDTO.toDomain())
  }

  @Test
  fun carToDomain() {
    assertEquals(car, carDTO.toDomain())
  }

  @Test
  fun consumerGoodsToDTO() {
    assertEquals(consumerGoodsDTO, ConsumerGoodsDTO(consumerGoods))
  }

  @Test
  fun serviceToDTO() {
    assertEquals(serviceDTO, ServiceDTO(service))
  }

  @Test
  fun carToDTO() {
    assertEquals(carDTO, CarDTO(car))
  }

  @Test
  fun consumerGoodsProductToProductDTO() {
    assertEquals(consumerGoodsDTO, productToProductDTO(consumerGoods))
  }

  @Test
  fun serviceProductToProductDTO() {
    assertEquals(serviceDTO, productToProductDTO(service))
  }

  @Test
  fun carProductToProductDTO() {
    assertEquals(carDTO, productToProductDTO(car))
  }

  @Test
  fun consumerGoodsProductDTOToProduct() {
    assertEquals(consumerGoods, productDTOToDomain(consumerGoodsDTO))
  }

  @Test
  fun serviceProductDTOToProduct() {
    assertEquals(service, productDTOToDomain(serviceDTO))
  }

  @Test
  fun carProductDTOToProduct() {
    assertEquals(car, productDTOToDomain(carDTO))
  }
}