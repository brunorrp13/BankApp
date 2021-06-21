package com.example.bankapp.data.model


import com.google.gson.annotations.SerializedName

data class ExtratoItem(
    @SerializedName("data")
    val data: String,
    @SerializedName("descricao")
    val descricao: String,
    @SerializedName("valor")
    val valor: Double
)