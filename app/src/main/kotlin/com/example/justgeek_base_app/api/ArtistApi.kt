package com.example.justgeek_base_app.api

import com.example.justgeek_base_app.data.ArtistData
import retrofit2.http.GET

interface ArtistApi {
    @GET("/artists")
    suspend fun getAllArtists() : List<ArtistData>
}