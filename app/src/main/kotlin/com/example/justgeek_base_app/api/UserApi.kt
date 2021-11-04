package com.example.justgeek_base_app.api

import com.example.justgeek_base_app.data.DataUser
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {
    @POST("/account/register")
    suspend fun singUpUser(@Body user: DataUser): Unit
}