package com.example.justgeek_base_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ProductAdapter(private val productList: List<ProductItem>):  RecyclerView.Adapter<ProductViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.showcase_item, parent, false)
        return ProductViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val currentItem = productList[position]
        Picasso.get().load(currentItem.productImage).into(holder.productImage)
        holder.discount.text = currentItem.discount.toString()
        holder.name.text = currentItem.name
        holder.price.text = currentItem.price.toString()
        holder.oldPrice.text = currentItem.oldPrice.toString()
    }

    override fun getItemCount(): Int = productList.size
}

class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val discount: TextView = itemView.findViewById()
    val name: TextView  = itemView.findViewById(R.id.)
    val price: TextView  = itemView.findViewById(R.id.)
    val oldPrice: TextView  = itemView.findViewById(R.id.)
    val productImage: ImageView = itemView.findViewById(R.id.)
}
