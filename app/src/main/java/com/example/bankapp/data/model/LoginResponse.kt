package com.example.bankapp.data.model


import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("cpf")
    val cpf: String,
    @SerializedName("nome")
    val nome: String,
    @SerializedName("saldo")
    val saldo: Double,
    @SerializedName("token")
    val token: String
)