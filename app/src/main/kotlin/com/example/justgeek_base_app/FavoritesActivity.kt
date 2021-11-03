package com.example.justgeek_base_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class FavoritesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val favorites = FavoritesFragment()
        fragmentTransaction.add(R.id.fragment_favorites_page, favorites)
        fragmentTransaction.commit()
    }
}