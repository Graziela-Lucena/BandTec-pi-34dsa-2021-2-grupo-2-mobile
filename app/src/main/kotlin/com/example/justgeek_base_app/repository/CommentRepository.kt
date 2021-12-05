package com.example.justgeek_base_app.repository

import com.example.justgeek_base_app.api.CommentApi
import com.example.justgeek_base_app.data.CommentItem
import br.com.arch.toolkit.livedata.response.MutableResponseLiveData
import br.com.arch.toolkit.livedata.response.ResponseLiveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CommentRepository(private val product: CommentApi) {
    fun getHomeComments(): ResponseLiveData<List<CommentItem>> {
        val liveData:  MutableResponseLiveData<List<CommentItem>> = MutableResponseLiveData<List<CommentItem>>()
        GlobalScope.launch {
            try {
                liveData.postLoading()
                val productLiveData = product.getHomeComments()
                liveData.postData(productLiveData)
            } catch (e: Exception) {
                liveData.postError(e)
            }
        }
        return liveData
    }
    fun getProductComments(idProduct: Int): ResponseLiveData<List<CommentItem>> {
        val liveData:  MutableResponseLiveData<List<CommentItem>> = MutableResponseLiveData<List<CommentItem>>()
        GlobalScope.launch {
            try {
                liveData.postLoading()
                val productLiveData = product.getProductComments(idProduct)
                liveData.postData(productLiveData)
            } catch (e: Exception) {
                liveData.postError(e)
            }
        }
        return liveData
    }
}