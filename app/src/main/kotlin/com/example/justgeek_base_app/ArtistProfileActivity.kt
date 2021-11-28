package com.example.justgeek_base_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ArtistProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artist_profile)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val similarArtists = ArtistsSimilarFragment()

        fragmentTransaction.add(R.id.fragment_others_artists, similarArtists)
        fragmentTransaction.commit()
    }
}