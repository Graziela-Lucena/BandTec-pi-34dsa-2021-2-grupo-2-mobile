package com.example.justgeek_base_app.repository

import br.com.arch.toolkit.livedata.response.MutableResponseLiveData
import br.com.arch.toolkit.livedata.response.ResponseLiveData
import com.example.justgeek_base_app.api.ArtistApi
import com.example.justgeek_base_app.api.CartApi
import com.example.justgeek_base_app.data.ArtistData
import com.example.justgeek_base_app.data.DataUser
import com.example.justgeek_base_app.data.ProductItem
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CartRepository(private val cart: CartApi) {
    fun addToCart(idUser: Int, idProduto: Int, quantidade: Int, tamanho: String): ResponseLiveData<Unit>  {
        val liveData:  MutableResponseLiveData<Unit> = MutableResponseLiveData<Unit>()
        GlobalScope.launch {
            try {
                liveData.postLoading()
                val cartLiveData = cart.addToCart(idUser, idProduto, quantidade, tamanho)
                liveData.postData(cartLiveData)
            } catch (e: Exception) {
                liveData.postError(e)
            }
        }
        return liveData
    }
    fun getCart(idUser: Int): ResponseLiveData<List<ProductItem>>  {
        val liveData:  MutableResponseLiveData<List<ProductItem>> = MutableResponseLiveData<List<ProductItem>>()
        GlobalScope.launch {
            try {
                liveData.postLoading()
                val cartLiveData = cart.getUserCart(idUser)
                liveData.postData(cartLiveData)
            } catch (e: Exception) {
                liveData.postError(e)
            }
        }
        return liveData
    }
}