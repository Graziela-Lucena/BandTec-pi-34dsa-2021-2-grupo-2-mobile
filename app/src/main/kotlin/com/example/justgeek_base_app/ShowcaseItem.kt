package com.example.justgeek_base_app

import androidx.annotation.DrawableRes

data class ShowcaseItem (
    @DrawableRes val background: Int,
    val title: String,
    val subtitle: String
)