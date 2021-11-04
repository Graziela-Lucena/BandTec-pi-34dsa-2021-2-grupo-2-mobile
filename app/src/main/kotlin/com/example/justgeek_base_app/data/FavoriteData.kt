package com.example.justgeek_base_app.data

import androidx.annotation.DrawableRes

data class FavoriteData(
    @DrawableRes val imageFavorite : Int,
    val reviewProduct : String,
    @DrawableRes val icFavorite : Int,
    val nameFavorite : String,
    val oldPriceFavorite : String,
    val newPriceFavorite : String
)
