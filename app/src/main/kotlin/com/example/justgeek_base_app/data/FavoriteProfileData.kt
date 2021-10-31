package com.example.justgeek_base_app.data

import androidx.annotation.DrawableRes

data class FavoriteProfileData(
    @DrawableRes val imageFavorite : Int,
    val nameFavorite : String,
    val oldPriceFavorite : String,
    val newPriceFavorite : String
)
