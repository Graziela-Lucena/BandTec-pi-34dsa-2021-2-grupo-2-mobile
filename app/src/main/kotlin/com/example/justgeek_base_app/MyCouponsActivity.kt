package com.example.justgeek_base_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import com.example.justgeek_base_app.adapter.CouponAdapter

class MyCouponsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_coupons)

        val fragmentTransactionCoupons = supportFragmentManager.beginTransaction()
        val fragmentCoupons = MyCouponsFragment()
        val ic_return_order_confirm = findViewById<AppCompatImageView>(R.id.ic_return_order_confirm)
        val button_apply_coupon_back = findViewById<AppCompatButton>(R.id.button_apply_coupon_back)

        fragmentTransactionCoupons.add(R.id.fragment_coupons, fragmentCoupons)
        fragmentTransactionCoupons.commit()

        ic_return_order_confirm.setOnClickListener { finish() }

        button_apply_coupon_back.setOnClickListener { finish() }
    }
}