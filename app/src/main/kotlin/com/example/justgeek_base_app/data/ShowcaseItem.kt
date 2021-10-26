package com.example.justgeek_base_app.data

import androidx.annotation.DrawableRes

data class ShowcaseItem (
    @DrawableRes val background: Int,
    val title: String,
    val subtitle: String
)