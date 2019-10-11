package com.ginzo.features.productdetails.productdetails_presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.ginzo.commons.entities.Product
import com.ginzo.commons.entities.dto.productDTOToDomain
import com.ginzo.commons.entities.dto.productToProductDTO
import com.ginzo.commons.feature_commons.view.bindView

class ProductDetailActivity : AppCompatActivity() {

  private val toolbar: Toolbar by bindView(R.id.product_detail_toolbar)
  private val image: ImageView by bindView(R.id.iv_product_details_image)
  private val name: TextView by bindView(R.id.tv_product_details_name)
  private val price: TextView by bindView(R.id.tv_product_details_price)
  private val category: TextView by bindView(R.id.tv_product_details_category)
  private val distance: TextView by bindView(R.id.tv_product_details_distance)
  private val type: TextView by bindView(R.id.tv_product_details_type)
  private val description: TextView by bindView(R.id.tv_product_details_description)

  private val consumerGoodsDetails: ConstraintLayout by bindView(R.id.cl_product_details_consumer_goods_details_container)
  private val color: TextView by bindView(R.id.tv_product_details_consumer_goods_color)

  private val serviceDetails: ConstraintLayout by bindView(R.id.cl_product_details_service_details_container)
  private val closingDay: TextView by bindView(R.id.tv_product_details_service_close_day)
  private val minAge: TextView by bindView(R.id.tv_product_details_service_minimum_age)

  private val carDetails: ConstraintLayout by bindView(R.id.cl_product_details_car_details_container)
  private val motor: TextView by bindView(R.id.tv_product_details_car_motor)
  private val gearbox: TextView by bindView(R.id.tv_product_details_car_gearbox)
  private val brand: TextView by bindView(R.id.tv_product_details_car_brand)
  private val km: TextView by bindView(R.id.tv_product_details_car_km)

  companion object {
    internal const val EXTRA_PRODUCT = "extra_product"

    fun getCallingIntent(context: Context, product: Product): Intent {
      val intent = Intent(context, ProductDetailActivity::class.java)
      intent.putExtra(EXTRA_PRODUCT, productToProductDTO(product))
      return intent
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_product_detail)

    toolbar.setNavigationOnClickListener { onBackPressed() }

    val product = productDTOToDomain(intent.getParcelableExtra(EXTRA_PRODUCT))

    renderSharedFields(product)

    when (product) {
      is Product.ConsumerGoods -> {
        category.text = product.category
        type.setText(R.string.consumer_goods)
        color.text = product.color

        consumerGoodsDetails.visibility = View.VISIBLE
        serviceDetails.visibility = View.GONE
        carDetails.visibility = View.GONE
      }

      is Product.Service -> {
        category.text = product.category
        closingDay.text = getString(R.string.close_day, product.closeDay)
        minAge.text = getString(R.string.min_age, product.minimunAge)
        type.setText(R.string.service)

        consumerGoodsDetails.visibility = View.GONE
        serviceDetails.visibility = View.VISIBLE
        carDetails.visibility = View.GONE
      }

      is Product.Car -> {
        category.visibility = View.GONE
        motor.text = product.motor
        gearbox.text = product.gearbox
        brand.text = product.brand
        km.text = getString(R.string.km, product.km)
        type.setText(R.string.car)

        consumerGoodsDetails.visibility = View.GONE
        serviceDetails.visibility = View.GONE
        carDetails.visibility = View.VISIBLE
      }
    }
  }

  private fun renderSharedFields(product: Product) {
    Glide.with(this)
      .load(product.image)
      .centerCrop()
      .into(image)

    name.text = product.name
    distance.text = getString(R.string.distance, product.distanceInMeters)
    price.text = product.price
    description.text = product.description
  }
}
