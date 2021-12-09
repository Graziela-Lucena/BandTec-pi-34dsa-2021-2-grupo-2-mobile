package com.example.justgeek_base_app.api

import com.example.justgeek_base_app.data.ProductItem
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface CartApi {
    @GET("/purchases/{idUser}")
    fun getUserCart(@Path("idUser") idUser: Int) : List<ProductItem>
    @POST("/products/add-product/{idUser}/{idProduct}/{quantidade}/{tamanho}")
    fun addToCart(
        @Path("idUser")idUser: Int,
        @Path("idProduct") idProduct: Int,
        @Path("quantidade") quantidade: Int,
        @Path("tamanho") tamanho: String
    ) : Unit
}