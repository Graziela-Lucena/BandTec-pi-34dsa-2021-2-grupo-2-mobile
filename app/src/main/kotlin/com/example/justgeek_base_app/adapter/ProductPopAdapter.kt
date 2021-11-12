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

class ProductPopAdapter(private val productList: List<ProductItem>):  RecyclerView.Adapter<ProductPopViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductPopViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.popular_product_item, parent, false)
        return ProductPopViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductPopViewHolder, position: Int) {
        val currentItem = productList[position]
        Picasso.get().load(currentItem.productImage).into(holder.productImage)
        holder.name.text = currentItem.name
        holder.price.text = currentItem.price
    }

    override fun getItemCount(): Int = productList.size

}

class ProductPopViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val name: TextView  = itemView.findViewById(R.id.title_product)
    val price: TextView  = itemView.findViewById(R.id.new_price)
    val productImage: ImageView = itemView.findViewById(R.id.shirt)
}
