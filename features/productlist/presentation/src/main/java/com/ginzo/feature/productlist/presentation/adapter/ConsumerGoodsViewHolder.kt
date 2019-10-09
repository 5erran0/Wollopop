package com.ginzo.feature.productlist.presentation.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.ginzo.commons.feature_commons.view.bindView
import com.ginzo.feature.productlist.presentation.R
import com.ginzo.features.productlist.domain.entities.Product

class ConsumerGoodsViewHolder(
  view: View,
  private val requestManager: RequestManager
) : RecyclerView.ViewHolder(view) {

  private val image: ImageView by bindView(R.id.iv_consumer_good_image)
  private val name: TextView by bindView(R.id.tv_consumer_good_name)
  private val distance: TextView by bindView(R.id.tv_consumer_good_distance)
  private val category: TextView by bindView(R.id.tv_consumer_good_category)
  private val price: TextView by bindView(R.id.tv_consumer_good_price)

  fun bind(product: Product.ConsumerGoods) {
    requestManager.load(product.image)
      .transform(CenterCrop(), RoundedCorners(8))
      .into(image)

    name.text = product.name
    category.text = product.category
    distance.text = "a ${product.distanceInMeters} m"
    price.text = product.price
  }
}