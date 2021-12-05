package com.example.justgeek_base_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val recentOrder = RecentOrderFragment()
        fragmentTransaction.add(R.id.fragment_recent_orders, recentOrder)
        fragmentTransaction.commit()

        val fragmentTransactionFavorites = supportFragmentManager.beginTransaction()
        val favorites = ProfileFavoriteFragment()
        fragmentTransactionFavorites.add(R.id.fragment_favorites, favorites)
        fragmentTransactionFavorites.commit()

        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigation_home -> {
                    startActivity(Intent(this, HomePageActivity::class.java))
                    overridePendingTransition(0,0)
                    true
                } else -> false
            }
        }

        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigation_home_logo -> {
                    startActivity(Intent(this, HomePageActivity::class.java))
                    overridePendingTransition(0,0)
                    true
                } else -> false
            }
        }

        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigation_favorites -> {
                    startActivity(Intent(this, FavoritesActivity::class.java))
                    overridePendingTransition(0,0)
                    true
                } else -> false
            }
        }
    }
}