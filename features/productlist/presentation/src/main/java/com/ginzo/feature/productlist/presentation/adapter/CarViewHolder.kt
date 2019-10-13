package com.ginzo.feature.productlist.presentation.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.ginzo.commons.entities.Product
import com.ginzo.commons.feature_commons.view.bindView
import com.ginzo.feature.productlist.presentation.R
import com.google.android.material.card.MaterialCardView

class CarViewHolder(
  private val view: View,
  private val requestManager: RequestManager,
  private val onClickProductListener: (Product) -> Unit
) : RecyclerView.ViewHolder(view) {

  private val image: ImageView by bindView(R.id.iv_car_image)
  private val card: MaterialCardView by bindView(R.id.mcv_car_container)
  private val name: TextView by bindView(R.id.tv_car_name)
  private val distance: TextView by bindView(R.id.tv_car_distance)
  private val price: TextView by bindView(R.id.tv_car_price)

  fun bind(product: Product.Car) {
    card.setOnClickListener { onClickProductListener(product) }

    requestManager.load(product.image)
      .into(image)

    name.text = product.name
    distance.text = view.context.getString(R.string.distance, product.distanceInMeters)
    price.text = product.price
  }
}