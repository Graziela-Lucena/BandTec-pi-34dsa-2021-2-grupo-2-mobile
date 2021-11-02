package com.example.justgeek_base_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ProfileOrdersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_orders)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val recentOrder = ProfileOrderFragment()
        fragmentTransaction.add(R.id.fragment_orders, recentOrder)
        fragmentTransaction.commit()
    }
}