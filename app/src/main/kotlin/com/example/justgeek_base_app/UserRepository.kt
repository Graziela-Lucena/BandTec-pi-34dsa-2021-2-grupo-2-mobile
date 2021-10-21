package com.example.justgeek_base_app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.arch.toolkit.livedata.response.MutableResponseLiveData
import br.com.arch.toolkit.livedata.response.ResponseLiveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.await


class UserRepository(private val userApi: UserApi) {
    fun singUpUser(userData: DataUser): ResponseLiveData<Unit> {
        val liveData:  MutableResponseLiveData<Unit> = MutableResponseLiveData<Unit>()
        GlobalScope.launch {
            try {
                liveData.postLoading()
                val userLivedata = userApi.singUpUser(userData)
                liveData.postData(userLivedata)
            } catch (e: Exception) {
                liveData.postError(e)
            }
        }
        return liveData
    }
}