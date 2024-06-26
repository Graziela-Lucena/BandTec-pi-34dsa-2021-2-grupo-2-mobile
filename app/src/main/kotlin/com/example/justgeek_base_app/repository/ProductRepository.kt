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

    fun getProductById(idProduct: Int): ResponseLiveData<ProductItem> {
        val liveData:  MutableResponseLiveData<ProductItem> = MutableResponseLiveData<ProductItem>()
        GlobalScope.launch {
            try {
                liveData.postLoading()
                val idProductLiveData = product.getProductById(idProduct)
                liveData.postData(idProductLiveData)
            } catch (e: Exception) {
                liveData.postError(e)
            }
        }
        return liveData
    }

    fun rp(productItem: ProductItem): ResponseLiveData<Unit> {
        val liveData:  MutableResponseLiveData<Unit> = MutableResponseLiveData<Unit>()
        GlobalScope.launch {
            try {
                liveData.postLoading()
                val idProductLiveData = product.registerProduct(productItem.idProduto, productItem)
                liveData.postData(idProductLiveData)
            } catch (e: Exception) {
                liveData.postError(e)
            }
        }
        return liveData
    }

}