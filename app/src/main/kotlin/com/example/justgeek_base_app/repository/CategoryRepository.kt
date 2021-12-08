package com.example.justgeek_base_app.repository

import br.com.arch.toolkit.livedata.response.MutableResponseLiveData
import br.com.arch.toolkit.livedata.response.ResponseLiveData
import com.example.justgeek_base_app.api.CategoryApi
import com.example.justgeek_base_app.data.ProductItem
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CategoryRepository(private val categoryProduct : CategoryApi) {
    fun getProduct() : ResponseLiveData<List<ProductItem>> {
        val liveData : MutableResponseLiveData<List<ProductItem>> = MutableResponseLiveData<List<ProductItem>>()
        GlobalScope.launch {
            try {
                liveData.postLoading()
                val productLiveData = categoryProduct.getAllProducts()
                liveData.postData(productLiveData)
            } catch (e: Exception) {
                liveData.postError(e)
            }
        }
        return liveData
    }
}