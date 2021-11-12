package com.example.justgeek_base_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

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

        val fragmentTransactionComment = supportFragmentManager.beginTransaction()
        val fragmentComment = CommentFragment()
        fragmentTransactionComment.add(R.id.fragment_container_comment, fragmentComment)
        fragmentTransactionComment.commit()

        val fragmentTransactionCoupon = supportFragmentManager.beginTransaction()
        val fragmentCoupon = FirstPurchaseCouponFragment()
        fragmentTransactionComment.add(R.id.fragment_coupon_container, fragmentCoupon)
        fragmentTransactionCoupon.commit()
    }
}