package com.example.justgeek_base_app.data

import com.google.gson.annotations.SerializedName

data class SignInBody(
    @SerializedName("email")
    val email : String,
    @SerializedName("senha")
    val senha : String
)
