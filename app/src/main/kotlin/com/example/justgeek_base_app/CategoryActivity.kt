package com.example.justgeek_base_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.google.android.material.bottomnavigation.BottomNavigationView

class CategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        val fragmentTransitionCategory = supportFragmentManager.beginTransaction()
        val categoryFragment = CategoryFragment()
        val ic_cart_category = findViewById<ImageView>(R.id.ic_cart_category)
        val bottom_navigation_category = findViewById<BottomNavigationView>(R.id.bottom_navigation_category)

        fragmentTransitionCategory.add(R.id.fragment_category_products, categoryFragment)
        fragmentTransitionCategory.commit()

        ic_cart_category.setOnClickListener {
            startActivity(Intent(this, MyCartActivity::class.java))
        }

        bottom_navigation_category.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigation_home -> {
                    finish()
                    overridePendingTransition(0,0)
                    true
                } else -> false
            }
        }
    }
}