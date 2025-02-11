package br.com.dimensao.gabgames.model

import com.google.gson.annotations.SerializedName

data class InfoGamerJson(
    val name: String,
    val email: String,
    @SerializedName("dataBirth") val birth: String,
    val user: String
)