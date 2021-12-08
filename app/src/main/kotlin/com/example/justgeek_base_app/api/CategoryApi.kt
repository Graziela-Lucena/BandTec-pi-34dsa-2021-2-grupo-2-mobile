package com.example.justgeek_base_app.api

import com.example.justgeek_base_app.data.ProductItem
import retrofit2.http.GET

interface CategoryApi {
    @GET("/filter/all-the-products")
    suspend fun getAllProducts() : List<ProductItem>
}