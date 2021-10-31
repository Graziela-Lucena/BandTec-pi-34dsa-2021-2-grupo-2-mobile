package com.example.justgeek_base_app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.justgeek_base_app.R
import com.example.justgeek_base_app.data.FavoriteProfileData
import com.squareup.picasso.Picasso

class ProfileFavoriteAdapter(private val favoriteAdapter: List<FavoriteProfileData>) : RecyclerView.Adapter<ProfileFavoriteOnViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileFavoriteOnViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_profile_favorite_item, parent, false)
        return ProfileFavoriteOnViewHolder(itemView)
    }

    override fun getItemCount(): Int = favoriteAdapter.size

    override fun onBindViewHolder(holder: ProfileFavoriteOnViewHolder, position: Int) {
        val current = favoriteAdapter[position]

        Picasso.get().load(current.imageFavorite).into(holder.imageFavorite)
        holder.nameFavorite.text = current.nameFavorite
        holder.oldPriceFavorite.text = current.oldPriceFavorite
        holder.newPriceFavorite.text = current.newPriceFavorite
    }
}

class ProfileFavoriteOnViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    val imageFavorite : AppCompatImageView = itemView.findViewById(R.id.shirt_favorite)
    val nameFavorite : AppCompatTextView = itemView.findViewById(R.id.title_name_favorite)
    val oldPriceFavorite : AppCompatTextView = itemView.findViewById(R.id.title_favorite_old_price)
    val newPriceFavorite : AppCompatTextView = itemView.findViewById(R.id.title_favorite_new_price)
}