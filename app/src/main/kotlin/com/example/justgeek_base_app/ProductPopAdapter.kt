package com.example.justgeek_base_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ProductPopAdapter(private val productList: List<ProductItem>):  RecyclerView.Adapter<ProductPopViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductPopViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_homepage_second_itens, parent, false)
        return ProductPopViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductPopViewHolder, position: Int) {
        val currentItem = productList[position]
        Picasso.get().load(currentItem.productImage).into(holder.productImage)
        holder.discount.text = currentItem.discount
        holder.name.text = currentItem.name
        holder.price.text = currentItem.price
        holder.oldPrice.text = currentItem.oldPrice
    }

    override fun getItemCount(): Int = productList.size

}

class ProductPopViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val discount: TextView = itemView.findViewById(R.id.text_promotion)
    val name: TextView  = itemView.findViewById(R.id.title_product)
    val price: TextView  = itemView.findViewById(R.id.new_price)
    val oldPrice: TextView  = itemView.findViewById(R.id.old_price)
    val productImage: ImageView = itemView.findViewById(R.id.shirt)
}
