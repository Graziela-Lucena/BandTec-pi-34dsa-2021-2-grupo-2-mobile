package com.example.justgeek_base_app.viewmodel

import androidx.lifecycle.ViewModel
import br.com.arch.toolkit.livedata.response.ResponseLiveData
import com.example.justgeek_base_app.data.ProductItem
import com.example.justgeek_base_app.repository.CartRepository

class CartViewModel(private val repository: CartRepository): ViewModel() {
    fun getCart(idUser: Int): ResponseLiveData<List<ProductItem>> {
        return repository.getCart(idUser)
    }

    fun addToCart(idUser: Int, idProduto: Int, quantidade: Int, tamanho: String): ResponseLiveData<Unit> {
        return repository.addToCart(idUser, idProduto, quantidade, tamanho)
    }
}