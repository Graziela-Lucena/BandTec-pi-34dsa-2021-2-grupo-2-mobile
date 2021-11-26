package com.example.justgeek_base_app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.justgeek_base_app.R
import com.example.justgeek_base_app.data.ArtistData
import com.example.justgeek_base_app.data.ProductItem
import com.squareup.picasso.Picasso

class ArtistsAdapter(private val artistList: List<ArtistData>):  RecyclerView.Adapter<ArtistViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.artist_item, parent, false)
        return ArtistViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        val currentItem = artistList[position]
        Picasso.get().load(currentItem.imagemPerfil).into(holder.artistImage)
        holder.description.text = currentItem.biografia
        holder.name.text = currentItem.nomeCompleto
    }

    override fun getItemCount(): Int = artistList.size
}

class ArtistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val description: TextView = itemView.findViewById(R.id.desc_artist)
    val name: TextView  = itemView.findViewById(R.id.name_artist)
    val artistImage: ImageView = itemView.findViewById(R.id.photo_artist)
}
