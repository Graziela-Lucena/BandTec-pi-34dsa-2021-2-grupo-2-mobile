package com.example.justgeek_base_app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.justgeek_base_app.R
import com.example.justgeek_base_app.data.ArtistItemData
import com.squareup.picasso.Picasso

class ArtFromArtistAdapter(private val artList: List<ArtistItemData>):  RecyclerView.Adapter<ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_homepage_itens, parent, false)
        return ProductViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val currentItem = artList[position]
        Picasso.get().load(currentItem.artImage).into(holder.productImage)
        holder.name.text = currentItem.nameArtist
    }

    override fun getItemCount(): Int = artList.size

    class ArtViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameArtist: TextView = itemView.findViewById(R.id.title_artists_showroom)
        val artImage: ImageView = itemView.findViewById(R.id.art_image)
    }

}