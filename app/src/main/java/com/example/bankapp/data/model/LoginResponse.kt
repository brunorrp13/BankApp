package com.example.bankapp.data.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LoginResponse(
    @SerializedName("nome")
    val nome: String,
    @SerializedName("cpf")
    val cpf: String,
    @SerializedName("saldo")
    val saldo: String,
    @SerializedName("token")
    val token: String
): Serializable