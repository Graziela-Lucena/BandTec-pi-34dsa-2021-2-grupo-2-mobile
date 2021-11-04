package com.example.justgeek_base_app.viewmodel

import androidx.lifecycle.ViewModel
import br.com.arch.toolkit.livedata.response.ResponseLiveData
import com.example.justgeek_base_app.repository.UserRepository
import com.example.justgeek_base_app.data.DataUser

class UserViewModel(private val repository: UserRepository): ViewModel() {
    fun singUpUser(userData: DataUser) : ResponseLiveData<Unit>{
        return repository.singUpUser(userData)
    }
}