package com.example.justgeek_base_app.repository

import br.com.arch.toolkit.livedata.response.MutableResponseLiveData
import br.com.arch.toolkit.livedata.response.ResponseLiveData
import com.example.justgeek_base_app.api.UserApi
import com.example.justgeek_base_app.data.DataUser
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

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