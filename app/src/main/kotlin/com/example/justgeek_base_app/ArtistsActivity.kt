package com.example.justgeek_base_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.justgeek_base_app.adapter.ArtistsAdapter
import com.example.justgeek_base_app.data.ArtistData
import java.util.ArrayList

class ArtistsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artists)

        val listArtist : List<ArtistData> = mutableListOf(
            ArtistData(
                0,
                R.drawable.bg_artist,
                "Graziela Lucena",
                "Grazi",
                19,
                "Biography",
                true,
                "grazi@bandtec.com.br",
                "instagram",
                "twitter",
                "cartoon",
                arrayOf("desenhos", "figma"),
            ),
            ArtistData(
                0,
                R.drawable.bg_artist,
                "Taiza Marques",
                "Tai",
                20,
                "Biography",
                true,
                "taiza@bandtec.com.br",
                "instagram",
                "twitter",
                "cartoon",
                arrayOf("desenhos", "figma"),
            ),
            ArtistData(
                0,
                R.drawable.bg_artist,
                "Gabriel Santos",
                "Santos",
                20,
                "Biography",
                true,
                "gabriel@bandtec.com.br",
                "instagram",
                "twitter",
                "cartoon",
                arrayOf("desenhos", "figma"),
            ),
            ArtistData(
                0,
                R.drawable.bg_artist,
                "Gisele Flor",
                "Gi",
                23,
                "Biography",
                true,
                "gisele@bandtec.com.br",
                "instagram",
                "twitter",
                "cartoon",
                arrayOf("desenhos", "figma"),
            )
        )

        val recycler = findViewById<RecyclerView>(R.id.recycler_artists)

        val adapter = ArtistsAdapter(listArtist)

        val layoutManeger = GridLayoutManager(this, 2)

        recycler.adapter = adapter
        recycler.layoutManager = layoutManeger


    }
}