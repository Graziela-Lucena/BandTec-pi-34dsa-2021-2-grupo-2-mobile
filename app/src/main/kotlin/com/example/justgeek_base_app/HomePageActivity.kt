package com.example.justgeek_base_app

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class HomePageActivity: AppCompatActivity(R.layout.homepage_activity) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
    }
}