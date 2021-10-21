package com.example.justgeek_base_app

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

class HomePageActivity: AppCompatActivity(R.layout.homepage_activity) {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        val fragmentTransaction = supportFragmentManager.beginTransaction()

        val showcaseFragment = ShowcaseFragment()
        fragmentTransaction.add(R.id.fragment_container_showcase, showcaseFragment)
        fragmentTransaction.commit()

    }
}