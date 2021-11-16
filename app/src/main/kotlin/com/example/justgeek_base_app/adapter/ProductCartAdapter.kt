package com.example.justgeek_base_app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.justgeek_base_app.R
import com.example.justgeek_base_app.data.ProductCartData
import com.squareup.picasso.Picasso

class ProductCartAdapter(private val productAdapterList : List<ProductCartData>)
    : RecyclerView.Adapter<ProductCartOnViewHold>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductCartOnViewHold {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_my_cart_item, parent, false)
        return ProductCartOnViewHold(itemView)
    }

    override fun getItemCount(): Int = productAdapterList.size

    override fun onBindViewHolder(holder: ProductCartOnViewHold, position: Int) {
        val current = productAdapterList[position]
        Picasso.get().load(current.imageProduct).into(holder.imageProduct)
        holder.productName.text = current.productName
        holder.productPrice.text = current.productPrice
        holder.productQuantity.text = current.productQuantity
        }
    }

class ProductCartOnViewHold(itemView : View) : RecyclerView.ViewHolder(itemView) {
    val imageProduct : AppCompatImageView = itemView.findViewById(R.id.image_item_bag)
    val productName : AppCompatTextView = itemView.findViewById(R.id.title_name_item_bag)
    val productPrice : AppCompatTextView = itemView.findViewById(R.id.title_price_item_bag)
    val productQuantity : AppCompatTextView = itemView.findViewById(R.id.result_quantity)
}