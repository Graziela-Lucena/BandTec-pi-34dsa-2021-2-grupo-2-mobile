package com.example.justgeek_base_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.justgeek_base_app.adapter.ArtistsAdapter
import com.example.justgeek_base_app.data.ArtistData
import com.example.justgeek_base_app.viewmodel.ArtistViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.ArrayList

class ArtistsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artists)
        val viewModel: ArtistViewModel by viewModel()

        val recycler = findViewById<RecyclerView>(R.id.recycler_artists)

        viewModel.getAllArtists().observe(this) {
            data {
                recycler.adapter = ArtistsAdapter(it)
            }
        }

        val layoutManeger = GridLayoutManager(this, 2)
        recycler.layoutManager = layoutManeger


    }
}