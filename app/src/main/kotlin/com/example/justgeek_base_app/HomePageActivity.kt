package com.example.justgeek_base_app

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class HomePageActivity: AppCompatActivity(R.layout.homepage_activity) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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

        iconCart.setOnClickListener {
            startActivity(Intent(this, MyCartActivity::class.java))
        }
    }
}