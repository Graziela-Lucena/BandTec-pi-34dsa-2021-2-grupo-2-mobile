package com.example.justgeek_base_app.api

import com.example.justgeek_base_app.data.ArtistData
import retrofit2.http.GET
import retrofit2.http.Path

interface ArtistApi {
    @GET("/artists/{idArtista}")
    fun getArtist(@Path("idArtista") idArtista: Int): ArtistData

    @GET("/artist-image/perfil/{idArtista}")
    fun getProfilePicture(@Path("idArtista") idArtista: Int): String

    @GET("/artist-image/images/{idArtista}")
    fun getGallery(@Path("idArtista") idArtista: Int): List<String>

    @GET("/artists")
    fun getAllArtists(): List<ArtistData>

    @GET("/artists/similar/{idArtista}")
    fun getSimilarArtists(@Path("idArtista") idArtista: Int): List<ArtistData>

    @GET("/artists/my-list/{idUser}")
    fun getFavoriteArtists(@Path("idUser") idUser: Int): List<ArtistData>

}