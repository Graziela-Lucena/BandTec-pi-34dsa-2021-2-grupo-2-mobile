package com.example.justgeek_base_app.data

import com.google.gson.annotations.SerializedName

class ArtistData(
    @SerializedName("idArtista")
    val idArtista: Int?,
    @SerializedName("imagemPerfil")
    val imagemPerfil: List<String?>,
    @SerializedName("nome")
    val nomeCompleto: String?,
    @SerializedName("apelido")
    val apelido: String?,
    @SerializedName("biografia")
    val biografia: String?,
    @SerializedName("contato")
    val contato: String?,
    @SerializedName("redeSocial1")
    val redeSocial1: String?,
    @SerializedName("redeSocial2")
    val redeSocial2: String?,
    @SerializedName("categoria")
    val categoria: String?,
    @SerializedName("artes")
    val artes: String?,
    @SerializedName("skills")
    val skills: List<String?>,
    @SerializedName("programas")
    val programas : List<String?>
    )