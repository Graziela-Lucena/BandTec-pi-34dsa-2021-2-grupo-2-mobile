package com.example.justgeek_base_app.api

import com.example.justgeek_base_app.data.CommentItem
import retrofit2.http.GET

interface CommentApi{
    @GET("/products/best-rating")
    suspend fun getHomeComments(): List<CommentItem>
    @GET("/rating/{idProduct}")
    suspend fun getProductComments(idProduct: Int): List<CommentItem>
}