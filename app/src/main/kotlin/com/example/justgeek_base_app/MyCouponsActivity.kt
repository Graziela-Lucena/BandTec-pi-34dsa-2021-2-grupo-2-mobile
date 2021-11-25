package com.example.justgeek_base_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.justgeek_base_app.adapter.CouponAdapter

class MyCouponsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_coupons)

        val fragmentTransactionCoupons = supportFragmentManager.beginTransaction()
        val fragmentCoupons = MyCouponsFragment()
        fragmentTransactionCoupons.add(R.id.fragment_coupons, fragmentCoupons)
        fragmentTransactionCoupons.commit()
    }
}