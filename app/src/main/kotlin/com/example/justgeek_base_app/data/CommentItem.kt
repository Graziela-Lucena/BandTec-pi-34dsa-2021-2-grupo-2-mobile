package com.example.justgeek_base_app.data

import com.google.gson.annotations.SerializedName

class CommentItem (
    @SerializedName("nomeAvaliador")
    val name: String,
    @SerializedName("comentario")
    val comment: String,
    @SerializedName("nota")
    val rate: Float
)