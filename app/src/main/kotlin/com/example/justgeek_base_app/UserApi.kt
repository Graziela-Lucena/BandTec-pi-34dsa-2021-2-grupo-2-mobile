package com.example.justgeek_base_app

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApi {
    @GET("teste")
    fun getUser(@Query("in") teste:String) : Call<DataUser>
}