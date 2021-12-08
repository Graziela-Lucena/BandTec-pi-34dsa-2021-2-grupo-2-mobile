package com.example.justgeek_base_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class CategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        val fragmentTransitionCategory = supportFragmentManager.beginTransaction()
        val categoryFragment = CategoryFragment()
        fragmentTransitionCategory.add(R.id.fragment_category_products, categoryFragment)
        fragmentTransitionCategory.commit()
    }
}