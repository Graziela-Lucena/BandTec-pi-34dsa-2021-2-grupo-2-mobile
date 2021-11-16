package com.example.justgeek_base_app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.justgeek_base_app.R
import com.example.justgeek_base_app.data.FavoriteData
import com.squareup.picasso.Picasso

class FavoritesAdapter(private val favoriteAdapter: List<FavoriteData>) : RecyclerView.Adapter<FavoritesOrderViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesOrderViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_favorites_item, parent, false)
        return FavoritesOrderViewHolder(itemView)
    }

    override fun getItemCount(): Int = favoriteAdapter.size

    override fun onBindViewHolder(holder: FavoritesOrderViewHolder, position: Int) {
        val current = favoriteAdapter[position]

        Picasso.get().load(current.imageFavorite).into(holder.imageFavorite)
        holder.reviewProduct.text = current.reviewProduct
        Picasso.get().load(current.icFavorite).into(holder.icFavorite)
        holder.nameFavorite.text = current.nameFavorite
        holder.oldPriceFavorite.text = current.oldPriceFavorite
        holder.newPriceFavorite.text = current.newPriceFavorite
    }
}

class FavoritesOrderViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    val imageFavorite : AppCompatImageView = itemView.findViewById(R.id.image_favorite)
    val reviewProduct : AppCompatTextView = itemView.findViewById(R.id.title_review)
    val icFavorite : AppCompatImageView = itemView.findViewById(R.id.ic_favorite)
    val nameFavorite : AppCompatTextView = itemView.findViewById(R.id.title_product_name_favorite)
    val oldPriceFavorite : AppCompatTextView = itemView.findViewById(R.id.title_old_price_favorite)
    val newPriceFavorite : AppCompatTextView = itemView.findViewById(R.id.title_new_price_favorite)
}