package com.example.justgeek_base_app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.justgeek_base_app.R
import com.example.justgeek_base_app.data.ProductItem
import com.squareup.picasso.Picasso

class ProductPromotionCartAdapter(private val promotionList : List<ProductItem>) :
        RecyclerView.Adapter<ProductPromotionCartViewHold>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductPromotionCartViewHold {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_homepage_itens, parent, false)
        return ProductPromotionCartViewHold(itemView)
    }

    override fun getItemCount(): Int = promotionList.size

    override fun onBindViewHolder(holder: ProductPromotionCartViewHold, position: Int) {
        val current = promotionList[position]

        holder.discount.text = current.discount
        holder.name.text = current.name
        holder.price.text = current.price
        holder.oldPrice.text = current.oldPrice
        Picasso.get().load(current.productImage?.firstOrNull()).into(holder.productImage)
    }
        }

class ProductPromotionCartViewHold(itemView : View) : RecyclerView.ViewHolder(itemView) {
    val discount : TextView = itemView.findViewById(R.id.text_promotion)
    val name : TextView = itemView.findViewById(R.id.title_product)
    val price : TextView = itemView.findViewById(R.id.new_price)
    val oldPrice : TextView = itemView.findViewById(R.id.old_price)
    val productImage : ImageView = itemView.findViewById(R.id.shirt)
}