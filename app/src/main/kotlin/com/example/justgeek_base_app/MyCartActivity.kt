package com.example.justgeek_base_app

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.res.ResourcesCompat

class MyCartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_cart)

        val buttonPP = findViewById<AppCompatTextView>(R.id.button_pp_size)
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val fragmentTransactionPromotion = supportFragmentManager.beginTransaction()
        val itemsCart = MyCartFragment()
        val itemsPromo = MyCartPromotionFragment()

        fragmentTransaction.add(R.id.fragment_item_cart, itemsCart)
        fragmentTransactionPromotion.add(R.id.fragment_promotion_cart, itemsPromo)
        fragmentTransaction.commit()
        fragmentTransactionPromotion.commit()
    }

}