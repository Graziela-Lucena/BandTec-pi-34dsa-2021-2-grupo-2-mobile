package com.example.justgeek_base_app.viewmodel

import androidx.lifecycle.ViewModel
import br.com.arch.toolkit.livedata.response.ResponseLiveData
import com.example.justgeek_base_app.data.ProductItem
import com.example.justgeek_base_app.repository.ProductRepository

class ProductViewModel(private val repository: ProductRepository): ViewModel() {
    fun getPromotionalProduct() : ResponseLiveData<List<ProductItem>> {
        return repository.getPromotionProduct()
    }
    fun getPopularProduct(): ResponseLiveData<List<ProductItem>> {
        return repository.getPopularProduct()
    }
    fun getProductById(idProduct: Int) : ResponseLiveData<ProductItem> {
        return repository.getProductById(idProduct)
    }
}