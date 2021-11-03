package com.example.justgeek_base_app

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.justgeek_base_app.adapter.FavoritesAdapter
import com.example.justgeek_base_app.data.FavoriteData

class FavoritesFragment:Fragment(R.layout.fragment_favorites) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listFavorites : List<FavoriteData> = mutableListOf(
            FavoriteData(
                R.drawable.popular1,
                getString(R.string.title_review),
                R.drawable.ic_favorite,
                getString(R.string.title_product_name),
                getString(R.string.subtitle_old_price),
                getString(R.string.subtitle_new_price)
            ),
            FavoriteData(
                R.drawable.popular1,
                getString(R.string.title_review),
                R.drawable.ic_favorite,
                getString(R.string.title_product_name),
                getString(R.string.subtitle_old_price),
                getString(R.string.subtitle_new_price)
            ),
            FavoriteData(
                R.drawable.popular1,
                getString(R.string.title_review),
                R.drawable.ic_favorite,
                getString(R.string.title_product_name),
                getString(R.string.subtitle_old_price),
                getString(R.string.subtitle_new_price)
            ),
        )
        val adapter = FavoritesAdapter(listFavorites)
        val layout = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        val favorites = view.findViewById<RecyclerView>(R.id.recycler_favorites)
        favorites.adapter = adapter
        favorites.layoutManager = layout

        PagerSnapHelper().attachToRecyclerView(favorites)
    }
}