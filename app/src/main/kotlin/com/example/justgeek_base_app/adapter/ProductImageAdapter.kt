package com.example.justgeek_base_app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.justgeek_base_app.R
import com.squareup.picasso.Picasso

class ProductImageAdapter(private val imageList: List<String?>?):  RecyclerView.Adapter<ImageViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.product_images_items, parent, false)
        return ImageViewHolder(itemView)
    }

    override fun getItemCount(): Int = imageList!!.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        Picasso.get().load(imageList?.getOrNull(position)).into(holder.productImage)
    }
}

class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val productImage: ImageView = itemView.findViewById(R.id.product_image)
}