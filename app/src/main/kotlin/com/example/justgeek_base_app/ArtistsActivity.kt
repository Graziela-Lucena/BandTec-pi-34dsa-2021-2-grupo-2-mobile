package com.example.justgeek_base_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.justgeek_base_app.data.ArtistData
import java.util.ArrayList

class ArtistsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artists)

        val fragmentTransactionArtists = supportFragmentManager.beginTransaction()
        val artistsFragment = ArtistFragment()

        fragmentTransactionArtists.add(R.id.fragment_popular_artists, artistsFragment)
        fragmentTransactionArtists.commit()

    }
}