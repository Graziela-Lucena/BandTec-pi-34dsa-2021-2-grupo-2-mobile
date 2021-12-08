package com.example.justgeek_base_app.repository

import br.com.arch.toolkit.livedata.response.MutableResponseLiveData
import br.com.arch.toolkit.livedata.response.ResponseLiveData
import com.example.justgeek_base_app.api.ArtistApi
import com.example.justgeek_base_app.data.ArtistData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception

class ArtistRepository(private val artistList : ArtistApi) {
    fun getArtists() : ResponseLiveData<List<ArtistData>> {
        val liveData : MutableResponseLiveData<List<ArtistData>> =
            MutableResponseLiveData<List<ArtistData>>()
        GlobalScope.launch {
            try {
                liveData.postLoading()
                val artistLiveData = artistList.getAllArtists()
                liveData.postData(artistLiveData)
            } catch (e: Exception) {
                liveData.postError(e)
            }
        }
        return liveData
    }
}