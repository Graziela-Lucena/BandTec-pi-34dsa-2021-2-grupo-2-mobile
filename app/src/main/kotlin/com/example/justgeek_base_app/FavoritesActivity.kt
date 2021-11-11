package com.example.justgeek_base_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class FavoritesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val favorites = FavoritesFragment()
        fragmentTransaction.add(R.id.fragment_favorites_page, favorites)
        fragmentTransaction.commit()

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

        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigation_profile -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                    overridePendingTransition(0,0)
                    true
                } else -> false
            }
        }
    }
}