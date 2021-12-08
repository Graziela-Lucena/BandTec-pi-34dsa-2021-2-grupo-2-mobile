package com.example.justgeek_base_app

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.justgeek_base_app.data.ArtistData

class ArtistsSimilarFragment:Fragment(R.layout.fragment_artists_similar) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val listArtist : List<ArtistData> = mutableListOf(
//            ArtistData(
//                0,
//                R.drawable.bg_artist,
//                "Graziela Lucena",
//                "Grazi",
//                19,
//                "Biography",
//                true,
//                "grazi@bandtec.com.br",
//                "instagram",
//                "twitter",
//                "cartoon",
//                arrayOf("desenhos", "figma"),
//            ),
//            ArtistData(
//                0,
//                R.drawable.bg_artist,
//                "Taiza Marques",
//                "Tai",
//                20,
//                "Biography",
//                true,
//                "taiza@bandtec.com.br",
//                "instagram",
//                "twitter",
//                "cartoon",
//                arrayOf("desenhos", "figma"),
//            ),
//            ArtistData(
//                0,
//                R.drawable.bg_artist,
//                "Gabriel Santos",
//                "Santos",
//                20,
//                "Biography",
//                true,
//                "gabriel@bandtec.com.br",
//                "instagram",
//                "twitter",
//                "cartoon",
//                arrayOf("desenhos", "figma"),
//            ),
//            ArtistData(
//                0,
//                R.drawable.bg_artist,
//                "Gisele Flor",
//                "Gi",
//                23,
//                "Biography",
//                true,
//                "gisele@bandtec.com.br",
//                "instagram",
//                "twitter",
//                "cartoon",
//                arrayOf("desenhos", "figma"),
//            )
//        )
//
//        val recycler = view.findViewById<RecyclerView>(R.id.recycler_similar_artists)
//        val adapter = ArtistsAdapter(listArtist)
//        val layoutManeger = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
//        recycler.adapter = adapter
//        recycler.layoutManager = layoutManeger
//
//        PagerSnapHelper().attachToRecyclerView(recycler)
    }
}