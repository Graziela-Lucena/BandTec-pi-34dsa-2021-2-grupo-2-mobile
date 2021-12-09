package com.example.justgeek_base_app

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomePageActivity: AppCompatActivity(R.layout.homepage_activity) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val iconCart = findViewById<ImageView>(R.id.shop)


        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val showcaseFragment = ShowcaseFragment()
        fragmentTransaction.add(R.id.fragment_container_showcase, showcaseFragment)
        fragmentTransaction.commit()

        val fragmentTransactionPromo = supportFragmentManager.beginTransaction()
        val fragmentPromo = ProductPromoFragment()
        fragmentTransactionPromo.add(R.id.fragment_container_promo, fragmentPromo)
        fragmentTransactionPromo.commit()

        val fragmentTransactionPop = supportFragmentManager.beginTransaction()
        val fragmentPop = ProductPopFragment()
        fragmentTransactionPop.add(R.id.fragment_container_pop, fragmentPop)
        fragmentTransactionPop.commit()

        val fragmentTransactionComment = supportFragmentManager.beginTransaction()
        val fragmentComment = CommentFragment()
        fragmentTransactionComment.add(R.id.fragment_container_comment, fragmentComment)
        fragmentTransactionComment.commit()

        val fragmentTransactionCoupon = supportFragmentManager.beginTransaction()
        val fragmentCoupon = FirstPurchaseCouponFragment()
        fragmentTransactionComment.add(R.id.fragment_coupon_container, fragmentCoupon)
        fragmentTransactionCoupon.commit()

        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigation_profile -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
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
                R.id.navigation_category -> {
                    startActivity(Intent(this, CategoryActivity::class.java))
                    overridePendingTransition(0,0)
                    true
                } else -> false
            }
        }

        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigation_home_logo -> {
                    startActivity(Intent(this, ArtistsActivity::class.java))
                    overridePendingTransition(0,0)
                    true
                } else-> false
        }
        }

        iconCart.setOnClickListener {
            startActivity(Intent(this, MyCartActivity::class.java))
        }
    }
}