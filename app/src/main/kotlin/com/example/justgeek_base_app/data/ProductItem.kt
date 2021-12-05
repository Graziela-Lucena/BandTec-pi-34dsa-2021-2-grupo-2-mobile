package com.example.justgeek_base_app.data

import androidx.annotation.DrawableRes
import com.google.gson.annotations.SerializedName

class ProductItem (
    val discount: String,
    @SerializedName("nomeProduto")
    val name: String,
    @SerializedName("preco")
    val price: String,
    val oldPrice: String,
<<<<<<< Updated upstream
    @DrawableRes val productImage: Int
=======
    @SerializedName("imagens")
    val productImage: List<String?>?
>>>>>>> Stashed changes
)