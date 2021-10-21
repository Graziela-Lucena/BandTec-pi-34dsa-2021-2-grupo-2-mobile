package com.example.justgeek_base_app

import androidx.annotation.DrawableRes

class ProductItem (
    val discount: String,
    val name: String,
    val price: String,
    val oldPrice: String,
    @DrawableRes val productImage: Int
)