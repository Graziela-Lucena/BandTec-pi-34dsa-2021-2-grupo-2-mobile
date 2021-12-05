package com.example.justgeek_base_app.api

import com.example.justgeek_base_app.data.ProductItem
import retrofit2.http.GET

interface ProductApi {
    @GET("/filter/promotion")
    suspend fun getPromotionProduct(): List<ProductItem>

    @GET("/filter/most-popular")
    suspend fun getPopularProduct(): List<ProductItem>
}