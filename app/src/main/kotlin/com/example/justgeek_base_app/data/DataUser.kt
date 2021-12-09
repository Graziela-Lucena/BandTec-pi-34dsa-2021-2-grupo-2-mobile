package com.example.justgeek_base_app.data

import com.google.gson.annotations.SerializedName

data class DataUser (
    @SerializedName("idUsuario")
    val idUser: Int,
    @SerializedName("nome")
    val name: String,
    @SerializedName("sobrenome")
    val lastName: String,
    val cpf: String,
    @SerializedName("dataNascimento")
    val birthDate: String,
    @SerializedName("email")
    val userEmail: String,
    @SerializedName("celular")
    val cellphone: String,
    @SerializedName("senha")
    val password: String,
    @SerializedName("primeiroAcesso")
    var isFirstAccess: Boolean? = null,
    @SerializedName("primeiraCompra")
    val isFirstPurchase: Boolean
)