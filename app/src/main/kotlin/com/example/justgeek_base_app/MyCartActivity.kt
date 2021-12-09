package com.example.justgeek_base_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView


class MyCartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_cart)

        
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val fragmentTransactionPromotion = supportFragmentManager.beginTransaction()
        val itemsCart = MyCartFragment()
        val itemsPromo = MyCartPromotionFragment()
        val ic_finish_screen = findViewById<AppCompatImageView>(R.id.ic_close_cart)
        val button_proceed_purchase = findViewById<AppCompatButton>(R.id.button_proceed_with_purchase)

        fragmentTransaction.add(R.id.fragment_item_cart, itemsCart)
        fragmentTransactionPromotion.add(R.id.fragment_promotion_cart, itemsPromo)
        fragmentTransaction.commit()
        fragmentTransactionPromotion.commit()

        ic_finish_screen.setOnClickListener { finish() }

        button_proceed_purchase.setOnClickListener {
            startActivity(Intent(this, MyCartOrderConfirmationActivity::class.java))
        }
    }

}