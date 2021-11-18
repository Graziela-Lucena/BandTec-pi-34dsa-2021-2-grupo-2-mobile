package com.example.justgeek_base_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MyCartOrderConfirmationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_cart_order_confirmation)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val orderConfirmation = MyCartOrderConfirmationFragment()
        fragmentTransaction.add(R.id.fragment_bag_items_cart_confirmation, orderConfirmation)
        fragmentTransaction.commit()
    }
}