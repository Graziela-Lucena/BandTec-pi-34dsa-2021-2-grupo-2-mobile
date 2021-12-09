package com.example.justgeek_base_app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.justgeek_base_app.R
import com.squareup.picasso.Picasso

class GalleryAdapter(private var listImgs: List<String>): RecyclerView.Adapter<GalleryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_art_showroom_artist_page, parent, false)
        return GalleryViewHolder(itemView)
    }

    override fun getItemCount(): Int = listImgs.size

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        Picasso.get().load(listImgs[position]).into(holder.img)
    }
}

class GalleryViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    val img : AppCompatImageView = itemView.findViewById(R.id.art_image)
}