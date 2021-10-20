package com.example.justgeek_base_app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class UserRepository(private val user: UserApi, val userEmpty: DataUser) {

    fun singUpUser(
        name: String,
        lastName: String,
        cpf: String,
        birthDate: String,
        cellphone: String,
        emailUser: String,
        password: String  ): LiveData<DataUser> {
        val liveData: MutableLiveData<DataUser> = MutableLiveData<DataUser>()
        GlobalScope.launch {
            try {
                val user = user.singUpUser(name, lastName, cpf, birthDate, cellphone, emailUser, password)
                liveData.postValue(user)
            } catch (e: Exception) {
                liveData.postValue(userEmpty)
            }
        }
        return liveData
    }
}