package com.example.justgeek_base_app

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.justgeek_base_app.adapter.ArtistAdapter
import com.example.justgeek_base_app.viewmodel.ArtistViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class ArtistFragment : Fragment(R.layout.fragment_artists) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val artistViewModel : ArtistViewModel by viewModel()

        val showArtists = view.findViewById<RecyclerView>(R.id.recycler_artists)

        val layoutManagerArtist = GridLayoutManager(requireContext(), 2)

        showArtists.layoutManager = layoutManagerArtist

        PagerSnapHelper().attachToRecyclerView(showArtists)

        artistViewModel.getArtists().observe(viewLifecycleOwner) {
            data {
                val adapterArtist = ArtistAdapter(it)
                showArtists.adapter = adapterArtist
                Log.i("Taiza", it.toString())
            }
        }
    }
}