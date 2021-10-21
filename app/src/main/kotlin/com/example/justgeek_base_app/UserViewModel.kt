package com.example.justgeek_base_app

import androidx.lifecycle.ViewModel
import br.com.arch.toolkit.livedata.response.ResponseLiveData

class UserViewModel(private val repository: UserRepository): ViewModel() {
    fun singUpUser(userData: DataUser) : ResponseLiveData<Unit>{
        return repository.singUpUser(userData)
    }
}