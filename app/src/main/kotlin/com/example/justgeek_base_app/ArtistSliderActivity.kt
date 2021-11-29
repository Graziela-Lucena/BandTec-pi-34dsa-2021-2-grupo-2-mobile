package com.example.justgeek_base_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.justgeek_base_app.R

class ArtistSliderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artist_slider)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val fragmentTransactionPromotion = supportFragmentManager.beginTransaction()
        val itemsArtFromArtist = FragmentArtistSlider()

        fragmentTransaction.add(R.id.fragment_artists_container_art, itemsArtFromArtist)
        fragmentTransaction.commit()
        fragmentTransactionPromotion.commit()
    }
}