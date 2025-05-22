package br.com.dimensao.gabgames.model

import com.google.gson.annotations.SerializedName

data class InfoGamerJson(
    @SerializedName("nome") val name: String,
    @SerializedName("email") val email: String,
    @SerializedName("dataNascimento") val birth: String,
    @SerializedName("usuario") val user: String
)
