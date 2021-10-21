package com.example.justgeek_base_app

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.POST

interface UserApi {
    @POST("/account/register")
    suspend fun singUpUser(@Body user: DataUser): Unit
}