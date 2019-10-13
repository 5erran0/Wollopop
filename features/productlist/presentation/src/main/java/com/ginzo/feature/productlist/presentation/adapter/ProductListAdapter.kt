package com.ginzo.feature.productlist.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.ginzo.feature.productlist.presentation.R

class ProductListAdapter(
  private val requestManager: RequestManager,
  private val onClickProductListener: (com.ginzo.commons.entities.Product) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

  var products: List<com.ginzo.commons.entities.Product> = emptyList()
    set(value) {
      field = value
      notifyDataSetChanged()
    }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    return when (ViewType.values()[viewType]) {
      ViewType.CONSUMER_GOODS -> {
        val view = LayoutInflater.from(parent.context)
          .inflate(R.layout.item_product_consumer_goods, parent, false)
        ConsumerGoodsViewHolder(view, requestManager, onClickProductListener)
      }

      ViewType.CAR -> {
        val view = LayoutInflater.from(parent.context)
          .inflate(R.layout.item_product_car, parent, false)
        CarViewHolder(view, requestManager, onClickProductListener)
      }

      ViewType.SERVICE -> {
        val view = LayoutInflater.from(parent.context)
          .inflate(R.layout.item_product_service, parent, false)
        ServiceViewHolder(view, requestManager, onClickProductListener)
      }
    }
  }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    when (holder) {
      is ConsumerGoodsViewHolder -> {
        val consumerGoods = products[position] as com.ginzo.commons.entities.Product.ConsumerGoods
        holder.bind(consumerGoods)
      }

      is ServiceViewHolder -> {
        val service = products[position] as com.ginzo.commons.entities.Product.Service
        holder.bind(service)
      }

      is CarViewHolder -> {
        val car = products[position] as com.ginzo.commons.entities.Product.Car
        holder.bind(car)
      }
    }
  }

  override fun getItemCount(): Int {
    return products.size
  }

  override fun getItemViewType(position: Int): Int {
    return when (products[position]) {
      is com.ginzo.commons.entities.Product.ConsumerGoods -> ViewType.CONSUMER_GOODS.ordinal
      is com.ginzo.commons.entities.Product.Service -> ViewType.SERVICE.ordinal
      is com.ginzo.commons.entities.Product.Car -> ViewType.CAR.ordinal
    }
  }
}

enum class ViewType {
  CONSUMER_GOODS, SERVICE, CAR
}