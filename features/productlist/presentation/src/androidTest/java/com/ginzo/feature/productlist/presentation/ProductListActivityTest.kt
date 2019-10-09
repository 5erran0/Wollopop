package com.ginzo.feature.productlist.presentation

import android.content.Context
import android.content.Intent
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.ginzo.features.productlist.domain.entities.Product
import org.hamcrest.CoreMatchers.not
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ProductListActivityTest {
  private val context = ApplicationProvider.getApplicationContext<Context>()

  @Rule
  @JvmField
  val activityRule = ActivityTestRule(ProductListActivity::class.java)

  private val activity: ProductListActivity
    get() = activityRule.activity

  private fun runOnUiThread(runnable: () -> Unit) {
    activity.runOnUiThread(runnable)
  }

  @Before
  fun init() {
    activityRule.launchActivity(Intent(context, ProductListActivity::class.java))
  }

  @Test
  fun renderLoading() {
    runOnUiThread {
      activity.render(ProductListViewState.Loading)
    }

    onView(withId(R.id.product_list_progress_bar)).check(matches(isDisplayed()))
    onView(withId(R.id.product_list_recycler_view)).check(matches(not(isDisplayed())))
  }

  @Test
  fun renderShownConsumerGood() {

    val products = listOf(
      Product.ConsumerGoods(
        id = "5a7ab3e09798181675dc1751",
        image = "https://raw.githubusercontent.com/Wallapop/Wallapop-Android-Test-Resources/master/images/image9.jpg",
        price = "447€",
        name = "enim",
        color = "orange",
        category = "children",
        description = "Officia excepteur exercitation laborum cillum occaecat Lorem voluptate ad ullamco adipisicing adipisicing amet non. Dolor exercitation laborum sunt in ex elit officia non labore veniam culpa dolore. Ex ex tempor anim non.",
        distanceInMeters = 414
      )
    )

    runOnUiThread {
      activity.render(ProductListViewState.ShownProductList(products))
    }

    onView(withId(R.id.product_list_recycler_view)).check(matches(isDisplayed()))
    onView(withId(R.id.product_list_progress_bar)).check(matches(not(isDisplayed())))

    onView(withId(R.id.tv_consumer_good_name))
      .check(matches(isDisplayed()))
      .check(matches(withText(products[0].name)))

    onView(withId(R.id.tv_consumer_good_price))
      .check(matches(isDisplayed()))
      .check(matches(withText(products[0].price)))

    onView(withId(R.id.tv_consumer_good_category))
      .check(matches(isDisplayed()))
      .check(matches(withText(products[0].category)))
  }

  @Test
  fun renderShownService() {

    val products = listOf(
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
      )
    )

    runOnUiThread {
      activity.render(ProductListViewState.ShownProductList(products))
    }

    onView(withId(R.id.product_list_recycler_view)).check(matches(isDisplayed()))
    onView(withId(R.id.product_list_progress_bar)).check(matches(not(isDisplayed())))

    onView(withId(R.id.tv_service_name))
      .check(matches(isDisplayed()))
      .check(matches(withText(products[0].name)))

    onView(withId(R.id.tv_service_price))
      .check(matches(isDisplayed()))
      .check(matches(withText(products[0].price)))

    onView(withId(R.id.tv_service_category))
      .check(matches(isDisplayed()))
      .check(matches(withText(products[0].category)))
  }

  @Test
  fun renderShownCar() {

    val products = listOf(
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
      )
    )

    runOnUiThread {
      activity.render(ProductListViewState.ShownProductList(products))
    }

    onView(withId(R.id.product_list_recycler_view)).check(matches(isDisplayed()))
    onView(withId(R.id.product_list_progress_bar)).check(matches(not(isDisplayed())))

    onView(withId(R.id.tv_car_name))
      .check(matches(isDisplayed()))
      .check(matches(withText(products[0].name)))

    onView(withId(R.id.tv_car_price))
      .check(matches(isDisplayed()))
      .check(matches(withText(products[0].price)))
  }
}