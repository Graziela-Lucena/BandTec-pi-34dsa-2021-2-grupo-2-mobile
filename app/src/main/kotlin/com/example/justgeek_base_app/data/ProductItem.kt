package com.example.justgeek_base_app.data

import androidx.annotation.DrawableRes
import com.google.gson.annotations.SerializedName

class ProductItem (
    @SerializedName("idProduto")
    val idProduto: Int,
    val discount: String,
    @SerializedName("nomeProduto")
    val name: String,
    @SerializedName("preco")
    val price: String,
    val oldPrice: String,
    @SerializedName("imagens")
    val productImage: List<String?>?,
    @SerializedName("especificacoes")
    val description: String
)