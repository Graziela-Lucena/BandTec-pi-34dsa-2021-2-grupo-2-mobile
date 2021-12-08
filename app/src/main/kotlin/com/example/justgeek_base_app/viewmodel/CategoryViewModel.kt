package com.example.justgeek_base_app.viewmodel

import androidx.lifecycle.ViewModel
import br.com.arch.toolkit.livedata.response.ResponseLiveData
import com.example.justgeek_base_app.data.ProductItem
import com.example.justgeek_base_app.repository.CategoryRepository

class CategoryViewModel(private val repository: CategoryRepository) : ViewModel() {
    fun getAllProducts() : ResponseLiveData<List<ProductItem>> {
        return repository.getProduct()
    }
}