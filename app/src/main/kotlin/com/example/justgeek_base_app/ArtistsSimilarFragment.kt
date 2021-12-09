package com.example.justgeek_base_app

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.justgeek_base_app.adapter.ArtistsAdapter
import com.example.justgeek_base_app.data.ArtistData
import com.example.justgeek_base_app.viewmodel.ArtistViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class ArtistsSimilarFragment:Fragment(R.layout.fragment_artists_similar) {
    val artistViewModel: ArtistViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recycler = view.findViewById<RecyclerView>(R.id.recycler_similar_artists)
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        artistViewModel.getSimilarArtists(1).observe(viewLifecycleOwner) {
            data {
                val adapter = ArtistsAdapter(it) {

                }
                recycler.adapter = adapter
            }
        }

        recycler.layoutManager = layoutManager

        PagerSnapHelper().attachToRecyclerView(recycler)
    }
}