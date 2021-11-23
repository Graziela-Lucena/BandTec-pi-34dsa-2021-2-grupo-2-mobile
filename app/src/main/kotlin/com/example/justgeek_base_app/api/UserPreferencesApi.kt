package com.example.justgeek_base_app.api

import com.example.justgeek_base_app.data.UserAddresses
import retrofit2.http.GET

interface UserPreferencesApi {
    @GET("addresses/address/{idUser}")
    fun getUserAddresses(idUser: Int): List<UserAddresses>
}