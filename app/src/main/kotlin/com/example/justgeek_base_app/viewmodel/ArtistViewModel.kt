package com.example.justgeek_base_app.viewmodel

import androidx.lifecycle.ViewModel
import br.com.arch.toolkit.livedata.response.ResponseLiveData
import com.example.justgeek_base_app.data.ArtistData
import com.example.justgeek_base_app.repository.ArtistRepository

class ArtistViewModel(private val repository: ArtistRepository) : ViewModel() {
    fun getArtists() : ResponseLiveData<List<ArtistData>> {
        return repository.getArtists()
    }
}