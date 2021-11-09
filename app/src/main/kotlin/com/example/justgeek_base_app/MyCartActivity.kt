package com.example.justgeek_base_app

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatTextView

class MyCartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_cart)

        val buttonPP = findViewById<AppCompatTextView>(R.id.button_pp_size)
        val buttonP = findViewById<AppCompatTextView>(R.id.button_p_size)
        val buttonM = findViewById<AppCompatTextView>(R.id.button_m_size)
        val buttonG = findViewById<AppCompatTextView>(R.id.button_g_size)
        val buttonGG = findViewById<AppCompatTextView>(R.id.button_gg_size)
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val fragmentTransactionPromotion = supportFragmentManager.beginTransaction()
        val itemsCart = MyCartFragment()
        val itemsPromo = MyCartPromotionFragment()

        fragmentTransaction.add(R.id.fragment_item_cart, itemsCart)
        fragmentTransactionPromotion.add(R.id.fragment_promotion_cart, itemsPromo)
        fragmentTransaction.commit()
        fragmentTransactionPromotion.commit()
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    fun setBackgroundPP(v:View) {
        val buttonPP = findViewById<AppCompatTextView>(R.id.button_pp_size)


        buttonPP.setBackgroundDrawable(getDrawable(R.drawable.bg_hot_blue_size_choose))
        buttonPP.setTextColor(getColor(R.color.pattern_dark))
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    fun setBackgroundP(v:View) {
        val buttonP = findViewById<AppCompatTextView>(R.id.button_p_size)

        buttonP.setBackgroundDrawable(getDrawable(R.drawable.bg_hot_blue_size_choose))
        buttonP.setTextColor(getColor(R.color.pattern_dark))
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    fun setBackgroundM(v: View) {
        val buttonM = findViewById<AppCompatTextView>(R.id.button_m_size)

        buttonM.setBackgroundDrawable(getDrawable(R.drawable.bg_hot_blue_size_choose))
        buttonM.setTextColor(getColor(R.color.pattern_dark))
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    fun setBackgroundG(v: View) {
        val buttonG = findViewById<AppCompatTextView>(R.id.button_g_size)

        buttonG.setBackgroundDrawable(getDrawable(R.drawable.bg_hot_blue_size_choose))
        buttonG.setTextColor(getColor(R.color.pattern_dark))
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    fun setBackgroundGG(v: View) {
        val buttonGG = findViewById<AppCompatTextView>(R.id.button_gg_size)

        buttonGG.setBackgroundDrawable(getDrawable(R.drawable.bg_hot_blue_size_choose))
        buttonGG.setTextColor(getColor(R.color.pattern_dark))
    }

}