package com.example.justgeek_base_app.data

import androidx.annotation.DrawableRes

data class OrderData(
    @DrawableRes val imageOrder : Int,
    val dateOrder : String,
    val statusOrder : String
)
