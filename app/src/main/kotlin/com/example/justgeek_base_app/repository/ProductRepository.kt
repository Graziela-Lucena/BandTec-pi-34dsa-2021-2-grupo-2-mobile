package com.example.justgeek_base_app.repository

import br.com.arch.toolkit.livedata.response.MutableResponseLiveData
import br.com.arch.toolkit.livedata.response.ResponseLiveData
import com.example.justgeek_base_app.api.ProductApi
import com.example.justgeek_base_app.api.UserApi
import com.example.justgeek_base_app.data.DataUser
import com.example.justgeek_base_app.data.ProductItem
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ProductRepository(private val product: ProductApi) {
    fun getPromotionProduct(): ResponseLiveData<List<ProductItem>> {
        val liveData:  MutableResponseLiveData<List<ProductItem>> = MutableResponseLiveData<List<ProductItem>>()
        GlobalScope.launch {
            try {
                liveData.postLoading()
                val productLiveData = product.getPromotionProduct()
                liveData.postData(productLiveData)
            } catch (e: Exception) {
                liveData.postError(e)
            }
        }
        return liveData
    }
    fun getPopularProduct(): ResponseLiveData<List<ProductItem>> {
        val liveData:  MutableResponseLiveData<List<ProductItem>> = MutableResponseLiveData<List<ProductItem>>()
        GlobalScope.launch {
            try {
                liveData.postLoading()
                val productLiveData = product.getPopularProduct()
                liveData.postData(productLiveData)
            } catch (e: Exception) {
                liveData.postError(e)
            }
        }
        return liveData
    }
}