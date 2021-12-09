package com.example.justgeek_base_app.api

import com.example.justgeek_base_app.data.ProductItem
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ProductApi {
    @GET("/filter/promotion")
    suspend fun getPromotionProduct(): List<ProductItem>

    @GET("/filter/most-popular")
    suspend fun getPopularProduct(): List<ProductItem>

    @GET("filter/product/{idProduto}")
    suspend fun getProductById(@Path("idProduto") idProduto: Int): ProductItem

    @POST("/products/register/{idProduct}")
    suspend fun registerProduct(@Path("idProduto") idProduto: Int, @Body product: ProductItem): Unit
}