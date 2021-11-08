package com.example.justgeek_base_app.data

import androidx.annotation.DrawableRes

data class ProductCartData(
    @DrawableRes val imageProduct : Int,
    val productName : String,
    val productPrice : String,
    val productQuantity : String
)