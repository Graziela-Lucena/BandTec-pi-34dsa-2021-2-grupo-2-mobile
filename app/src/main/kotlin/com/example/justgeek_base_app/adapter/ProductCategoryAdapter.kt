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

class ProductCategoryAdapter (private val listCategoryProduct : List<ProductItem>)
    : RecyclerView.Adapter<CategoryProductViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryProductViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.popular_product_item, parent, false)
        return CategoryProductViewHolder(itemView)
        }

        override fun getItemCount(): Int = listCategoryProduct.size

        override fun onBindViewHolder(holder: CategoryProductViewHolder, position: Int) {
            val current = listCategoryProduct[position]

            current.productImage.let { Picasso.get().load(it?.firstOrNull()).into(holder.productImage) }
            holder.name.text = current.name
            holder.price.text = current.price
        }
    }

class CategoryProductViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
    val name: TextView = itemView.findViewById(R.id.title_product)
    val price: TextView = itemView.findViewById(R.id.new_price)
    val productImage: ImageView = itemView.findViewById(R.id.shirt)
}