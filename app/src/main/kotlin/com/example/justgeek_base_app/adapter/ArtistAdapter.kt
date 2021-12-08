package com.example.justgeek_base_app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.justgeek_base_app.R
import com.example.justgeek_base_app.data.ArtistData
import com.squareup.picasso.Picasso

class ArtistAdapter(private val listArtists : List<ArtistData>)
    : RecyclerView.Adapter<ArtistListViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistListViewHolder {
            val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.popular_product_item, parent, false)
            return ArtistListViewHolder(itemView)
        }

        override fun getItemCount(): Int = listArtists.size

    override fun onBindViewHolder(holder: ArtistListViewHolder, position: Int) {
        val current = listArtists[position]
        current.imagemPerfil.let { Picasso.get().load(it.firstOrNull()).into(holder.imagemPerfil) }
        holder.nomeCompleto.text = current.nomeCompleto
        holder.apelido.text = current.apelido
    }
    }

class ArtistListViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    val imagemPerfil = itemView.findViewById<ImageView>(R.id.photo_artist_list)
    val nomeCompleto = itemView.findViewById<TextView>(R.id.name_artist_list)
    val apelido = itemView.findViewById<TextView>(R.id.desc_artist)
}