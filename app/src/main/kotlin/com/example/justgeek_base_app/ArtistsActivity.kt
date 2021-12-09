package com.example.justgeek_base_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.justgeek_base_app.adapter.ArtistsAdapter
import com.example.justgeek_base_app.data.ArtistData

import com.google.android.material.bottomnavigation.BottomNavigationView

import com.example.justgeek_base_app.viewmodel.ArtistViewModel
import org.koin.android.viewmodel.ext.android.viewModel

import java.util.ArrayList

class ArtistsActivity : AppCompatActivity() {
    val viewModel: ArtistViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artists)


        val shop_artists = findViewById<ImageView>(R.id.shop_artists)
        val ic_return_from_artists = findViewById<AppCompatImageView>(R.id.ic_return_from_artists)
        val bottom_navigation_artists = findViewById<BottomNavigationView>(R.id.bottom_navigation_artists)

        shop_artists.setOnClickListener {
            startActivity(Intent(this, MyCartActivity::class.java))
        }

        ic_return_from_artists.setOnClickListener { finish() }

        bottom_navigation_artists.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigation_home -> {
                    finish()
                    overridePendingTransition(0,0)
                    true
                } else -> false
            }
        }

        bottom_navigation_artists.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigation_category -> {
                    startActivity(Intent(this, CategoryActivity::class.java))
                    overridePendingTransition(0,0)
                    true
                } else -> false
            }
        }

        bottom_navigation_artists.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigation_favorites -> {
                    startActivity(Intent(this, FavoritesActivity::class.java))
                    overridePendingTransition(0,0)
                    true
                } else -> false
            }
        }

        bottom_navigation_artists.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigation_profile -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                    overridePendingTransition(0,0)
                    true
                } else -> false
            }
        }



        val recycler = findViewById<RecyclerView>(R.id.recycler_artists)

        viewModel.getAllArtists().observe(this) {
            data {
                recycler.adapter = ArtistsAdapter(it) {
                    startActivity(Intent(this@ArtistsActivity, ArtistProfileActivity::class.java))
                }
            }
        }

        val layoutManeger = GridLayoutManager(this, 2)
        recycler.layoutManager = layoutManeger


    }
}