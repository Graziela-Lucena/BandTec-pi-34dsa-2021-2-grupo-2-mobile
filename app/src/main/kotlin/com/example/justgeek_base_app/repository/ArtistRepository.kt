package com.example.justgeek_base_app.repository

import br.com.arch.toolkit.livedata.response.MutableResponseLiveData
import br.com.arch.toolkit.livedata.response.ResponseLiveData
import com.example.justgeek_base_app.api.ArtistApi
import com.example.justgeek_base_app.api.CommentApi
import com.example.justgeek_base_app.data.ArtistData
import com.example.justgeek_base_app.data.CommentItem
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ArtistRepository(private val artist: ArtistApi) {
    fun getAllArtists(): ResponseLiveData<List<ArtistData>> {
        val liveData: MutableResponseLiveData<List<ArtistData>> = MutableResponseLiveData<List<ArtistData>>()
        GlobalScope.launch {
            try {
                liveData.postLoading()
                val artistLiveData = artist.getAllArtists()
                liveData.postData(artistLiveData)
            } catch (e: Exception) {
                liveData.postError(e)
            }
        }
        return liveData
    }

    fun getArtist(idArtista: Int): ResponseLiveData<ArtistData> {
        val liveData: MutableResponseLiveData<ArtistData> = MutableResponseLiveData<ArtistData>()
        GlobalScope.launch {
            try {
                liveData.postLoading()
                val artistLiveData = artist.getArtist(idArtista)
                val profileLiveData = artist.getProfilePicture(idArtista)
                val galleryLiveData = artist.getGallery(idArtista)
                artistLiveData.imagemPerfil = profileLiveData
                artistLiveData.artes = galleryLiveData
                liveData.postData(artistLiveData)
            } catch (e: Exception) {
                liveData.postError(e)
            }
        }
        return liveData
    }

    fun getSimilarArtists(idArtista: Int): ResponseLiveData<List<ArtistData>> {
        val liveData: MutableResponseLiveData<List<ArtistData>> = MutableResponseLiveData<List<ArtistData>>()
        GlobalScope.launch {
            try {
                liveData.postLoading()
                val artistLiveData = artist.getFavoriteArtists(idArtista)
                liveData.postData(artistLiveData)
            } catch (e: Exception) {
                liveData.postError(e)
            }
        }
        return liveData
    }

    fun getFavoriteArtists(idUser: Int): ResponseLiveData<List<ArtistData>> {
        val liveData: MutableResponseLiveData<List<ArtistData>> = MutableResponseLiveData<List<ArtistData>>()
        GlobalScope.launch {
            try {
                liveData.postLoading()
                val artistLiveData = artist.getFavoriteArtists(idUser)
                liveData.postData(artistLiveData)
            } catch (e: Exception) {
                liveData.postError(e)
            }
        }
        return liveData
    }
}