package com.example.justgeek_base_app.data

import androidx.annotation.DrawableRes

data class OrderItemConfirmation(
    @DrawableRes val imageOrderConfirmation : Int,
    val titleQuantityChosen : String
)
