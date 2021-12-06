package com.example.justgeek_base_app.api

import com.example.justgeek_base_app.data.CommentItem
import retrofit2.http.GET
import retrofit2.http.Path

interface CommentApi{
    @GET("/products/best-rating")
    suspend fun getHomeComments(): List<CommentItem>
    @GET("/products/rating/{idProduto}")
    suspend fun getProductComments(@Path("idProduto") idProduct: Int): List<CommentItem>
}