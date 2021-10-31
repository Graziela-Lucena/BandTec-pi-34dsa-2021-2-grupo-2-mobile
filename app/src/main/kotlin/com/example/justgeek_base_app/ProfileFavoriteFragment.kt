package com.example.justgeek_base_app

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.justgeek_base_app.adapter.ProfileFavoriteAdapter
import com.example.justgeek_base_app.data.FavoriteProfileData

class ProfileFavoriteFragment:Fragment(R.layout.fragment_profile_favorite) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listProfileFavorites : List<FavoriteProfileData> = mutableListOf(
            FavoriteProfileData(
                R.drawable.popular1,
                getString(R.string.title_product_name),
                getString(R.string.subtitle_old_price),
                getString(R.string.subtitle_new_price)
            ),
            FavoriteProfileData(
                R.drawable.popular1,
                getString(R.string.title_product_name),
                getString(R.string.subtitle_old_price),
                getString(R.string.subtitle_new_price)
            ),
        )
        val adapterProfileFavorites = ProfileFavoriteAdapter(listProfileFavorites)
        val layout = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        val favorites = view.findViewById<RecyclerView>(R.id.recycler_profile_favorites)

        favorites.adapter = adapterProfileFavorites
        favorites.layoutManager = layout
    }
}