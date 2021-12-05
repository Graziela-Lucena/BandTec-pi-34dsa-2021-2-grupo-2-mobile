package com.example.justgeek_base_app.viewmodel

import androidx.lifecycle.ViewModel
import br.com.arch.toolkit.livedata.response.ResponseLiveData
import com.example.justgeek_base_app.data.CommentItem
import com.example.justgeek_base_app.repository.CommentRepository

class CommentViewModel(private val repository: CommentRepository): ViewModel()  {
    fun getHomeComments() : ResponseLiveData<List<CommentItem>> {
        return repository.getHomeComments()
    }
    fun getProductComments(idProduct: Int) : ResponseLiveData<List<CommentItem>> {
        return repository.getProductComments(idProduct)
    }
}