package com.example.justgeek_base_app.data

class ArtistData(
    val idArtista: Int,
    var imagemPerfil: String,
    val nomeCompleto: String,
    val apelido: String,
    val idade: Int,
    val biografia: String,
    var artes: List<String>,
    val status: Boolean,
    val contato: String,
    val redeSocial1: String,
    val redeSocial2: String,
    val categoria: String,
    val skills: Array<String>
)