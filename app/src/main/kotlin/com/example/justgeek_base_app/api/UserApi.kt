package com.example.justgeek_base_app.api

import com.example.justgeek_base_app.data.DataUser
import retrofit2.http.*

interface UserApi {
    @POST("/account/register")
    suspend fun singUpUser(@Body user: DataUser): Unit
    @PUT("account/{idUsuario}")
    suspend fun updateUserInfo(@Path("idUsuario") idUser: Int, @Body user: DataUser) : Unit
    @GET("account/{idUsuario}")
    suspend fun getUser(@Path("idUsuario") idUser: Int) : DataUser
}