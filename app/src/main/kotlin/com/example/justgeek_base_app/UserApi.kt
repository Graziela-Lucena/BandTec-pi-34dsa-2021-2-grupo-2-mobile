package com.example.justgeek_base_app

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.POST

interface UserApi {
    @POST("/account/register")
    fun singUpUser(
        @Field("nome") name: String,
        @Field("sobrenome") lastName: String,
        @Field("cpf") cpf: String,
        @Field("dataNascimento") birthDate: String,
        @Field("celular") cellphone: String,
        @Field("email") emailUser: String,
        @Field("senha") password: String
    ) : DataUser
}