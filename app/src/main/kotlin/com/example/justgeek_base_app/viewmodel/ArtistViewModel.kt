package com.example.justgeek_base_app.viewmodel

import androidx.lifecycle.ViewModel
import br.com.arch.toolkit.livedata.response.ResponseLiveData
import com.example.justgeek_base_app.data.ArtistData
import com.example.justgeek_base_app.repository.ArtistRepository

class ArtistViewModel(private val repository: ArtistRepository): ViewModel() {
    fun getAllArtists() : ResponseLiveData<List<ArtistData>> {
        return repository.getAllArtists()
    }
    fun getArtist(idArtista: Int) : ResponseLiveData<ArtistData> {
        return repository.getArtist(idArtista)
    }

    fun getFavoriteArtists(idUser: Int) : ResponseLiveData<List<ArtistData>> {
        return repository.getFavoriteArtists(idUser)
    }
    fun getSimilarArtists(idArtista: Int) : ResponseLiveData<List<ArtistData>> {
        return repository.getSimilarArtists(idArtista)
    }
}