package com.ginzo.feature.productlist.presentation.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.ginzo.commons.feature_commons.view.bindView
import com.ginzo.feature.productlist.presentation.R
import com.ginzo.features.productlist.domain.entities.Product

class ServiceViewHolder(
  view: View,
  private val requestManager: RequestManager
) : RecyclerView.ViewHolder(view) {

  private val image: ImageView by bindView(R.id.iv_service_image)
  private val name: TextView by bindView(R.id.tv_service_name)
  private val distance: TextView by bindView(R.id.tv_service_distance)
  private val category: TextView by bindView(R.id.tv_service_category)
  private val price: TextView by bindView(R.id.tv_service_price)

  fun bind(product: Product.Service) {
    requestManager.load(product.image)
      .into(image)

    name.text = product.name
    category.text = product.category
    distance.text = "${product.distanceInMeters.toString()} m"
    price.text = product.price
  }
}