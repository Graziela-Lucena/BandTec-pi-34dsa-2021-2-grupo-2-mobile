package com.example.justgeek_base_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val recentOrder = RecentOrderFragment()
        fragmentTransaction.add(R.id.fragment_recent_orders, recentOrder)
        fragmentTransaction.commit()

        val fragmentTransactionFavorites = supportFragmentManager.beginTransaction()
        val favorites = ProfileFavoriteFragment()
        fragmentTransactionFavorites.add(R.id.fragment_favorites, favorites)
        fragmentTransactionFavorites.commit()
    }
}