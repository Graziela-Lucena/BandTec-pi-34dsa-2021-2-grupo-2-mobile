package com.example.justgeek_base_app

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitUser {
    fun retrofit(): Retrofit {
        val client = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply{
                level = HttpLoggingInterceptor.Level.BODY
            })
        val retrofit = Retrofit.Builder()
            .baseUrl("http://3.220.18.44:8081")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }
    fun user(retrofit: Retrofit): UserApi{
        return retrofit.create(UserApi::class.java)
    }


}