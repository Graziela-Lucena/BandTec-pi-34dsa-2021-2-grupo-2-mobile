package com.example.justgeek_base_app

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.justgeek_base_app.adapter.ArtFromArtistAdapter
import com.example.justgeek_base_app.data.ArtistItemData

class FragmentArtistSlider: Fragment(R.layout.fragment_art_from_artist)  {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val artFromArtistList : List<ArtistItemData> = mutableListOf(
            ArtistItemData(
                R.drawable.art_camiseta,
                getString(R.string.title_art_from_artist)
            ),

            ArtistItemData(
                R.drawable.art_camiseta,
                getString(R.string.title_art_from_artist)
            ),

            ArtistItemData(
                R.drawable.art_camiseta,
                getString(R.string.title_art_from_artist)
            ),

            ArtistItemData(
                R.drawable.art_camiseta,
                getString(R.string.title_art_from_artist)
            ),

            ArtistItemData(
                R.drawable.art_camiseta,
                getString(R.string.title_art_from_artist)
            )

        )

        val adapter = ArtFromArtistAdapter(artFromArtistList)
        val layout = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val itemsArtContainer = view.findViewById<RecyclerView>(R.id.recycler_container_arts)

        itemsArtContainer.adapter = adapter
        itemsArtContainer.layoutManager = layout

        PagerSnapHelper().attachToRecyclerView(itemsArtContainer)

    }
}