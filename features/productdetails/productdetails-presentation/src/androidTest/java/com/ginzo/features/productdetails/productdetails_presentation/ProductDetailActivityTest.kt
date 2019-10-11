package com.ginzo.features.productdetails.productdetails_presentation

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.ginzo.commons.entities.Product
import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import org.junit.Test

class ProductDetailActivityTest {
  @Rule
  @JvmField
  val activityRule = ActivityTestRule(ProductDetailActivity::class.java, false, false)

  private lateinit var activity: ProductDetailActivity

  @Test
  fun renderConsumerGood() {
    val product = Product.ConsumerGoods(
      id = "5a7ab3e09798181675dc1751",
      image = "https://raw.githubusercontent.com/Wallapop/Wallapop-Android-Test-Resources/master/images/image9.jpg",
      price = "447€",
      name = "enim",
      color = "orange",
      category = "children",
      description = "Officia excepteur exercitation laborum cillum occaecat Lorem voluptate ad ullamco adipisicing adipisicing amet non. Dolor exercitation laborum sunt in ex elit officia non labore veniam culpa dolore. Ex ex tempor anim non.",
      distanceInMeters = 414
    )

    launch(product)

    onView(withId(R.id.iv_product_details_image))
      .check(matches(isDisplayed()))

    onView(withId(R.id.tv_product_details_name))
      .check(matches(withText(product.name)))

    onView(withId(R.id.tv_product_details_price))
      .check(matches(withText(product.price)))

    onView(withId(R.id.tv_product_details_description))
      .check(matches(withText(product.description)))

    onView(withId(R.id.tv_product_details_category))
      .check(matches(withText(product.category)))

    onView(withId(R.id.tv_product_details_type))
      .check(matches(withText(R.string.consumer_goods)))

    onView(withId(R.id.cl_product_details_consumer_goods_details_container))
      .check(matches(isDisplayed()))

    onView(withId(R.id.cl_product_details_service_details_container))
      .check(matches(not(isDisplayed())))

    onView(withId(R.id.cl_product_details_car_details_container))
      .check(matches(not(isDisplayed())))

    onView(withId(R.id.tv_product_details_consumer_goods_color))
      .check(matches(withText(product.color)))

    onView(withId(R.id.tv_product_details_distance))
      .check(
        matches(
          withText(
            activityRule.activity.getString(
              R.string.distance,
              product.distanceInMeters
            )
          )
        )
      )
  }

  @Test
  fun renderService() {

    val product = Product.Service(
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

    launch(product)

    onView(withId(R.id.iv_product_details_image))
      .check(matches(isDisplayed()))

    onView(withId(R.id.tv_product_details_name))
      .check(matches(withText(product.name)))

    onView(withId(R.id.tv_product_details_price))
      .check(matches(withText(product.price)))

    onView(withId(R.id.tv_product_details_description))
      .check(matches(withText(product.description)))

    onView(withId(R.id.tv_product_details_category))
      .check(matches(withText(product.category)))

    onView(withId(R.id.tv_product_details_type))
      .check(matches(withText(R.string.service)))

    onView(withId(R.id.cl_product_details_consumer_goods_details_container))
      .check(matches(not(isDisplayed())))

    onView(withId(R.id.cl_product_details_service_details_container))
      .check(matches(isDisplayed()))

    onView(withId(R.id.cl_product_details_car_details_container))
      .check(matches(not(isDisplayed())))

    onView(withId(R.id.tv_product_details_service_close_day))
      .check(
        matches(
          withText(
            activityRule.activity.getString(
              R.string.close_day,
              product.closeDay
            )
          )
        )
      )

    onView(withId(R.id.tv_product_details_distance))
      .check(
        matches(
          withText(
            activityRule.activity.getString(
              R.string.distance,
              product.distanceInMeters
            )
          )
        )
      )

    onView(withId(R.id.tv_product_details_service_minimum_age))
      .check(
        matches(
          withText(
            activityRule.activity.getString(
              R.string.min_age,
              product.minimunAge
            )
          )
        )
      )
  }

  @Test
  fun renderCar() {

    val product = Product.Car(
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

    launch(product)

    onView(withId(R.id.iv_product_details_image))
      .check(matches(isDisplayed()))

    onView(withId(R.id.tv_product_details_name))
      .check(matches(withText(product.name)))

    onView(withId(R.id.tv_product_details_price))
      .check(matches(withText(product.price)))

    onView(withId(R.id.tv_product_details_description))
      .check(matches(withText(product.description)))

    onView(withId(R.id.tv_product_details_category))
      .check(matches(not(isDisplayed())))

    onView(withId(R.id.tv_product_details_type))
      .check(matches(withText(R.string.car)))

    onView(withId(R.id.cl_product_details_consumer_goods_details_container))
      .check(matches(not(isDisplayed())))

    onView(withId(R.id.cl_product_details_service_details_container))
      .check(matches(not(isDisplayed())))

    onView(withId(R.id.cl_product_details_car_details_container))
      .check(matches(isDisplayed()))

    onView(withId(R.id.tv_product_details_car_motor))
      .check(matches(withText(product.motor)))

    onView(withId(R.id.tv_product_details_car_gearbox))
      .check(matches(withText(product.gearbox)))

    onView(withId(R.id.tv_product_details_car_brand))
      .check(matches(withText(product.brand)))

    onView(withId(R.id.tv_product_details_car_km))
      .check(matches(withText(activityRule.activity.getString(R.string.km, product.km))))

    onView(withId(R.id.tv_product_details_distance))
      .check(
        matches(
          withText(
            activityRule.activity.getString(
              R.string.distance,
              product.distanceInMeters
            )
          )
        )
      )
  }

  private fun launch(product: Product) {
    val context = ApplicationProvider.getApplicationContext<Context>()
    activityRule.launchActivity(ProductDetailActivity.getCallingIntent(context, product))
    this.activity = activityRule.activity
  }
}
