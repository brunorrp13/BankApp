package com.example.bankapp.data.model

import com.google.gson.annotations.SerializedName

data class User(

    @SerializedName("cpf")
    val cpf: String,
    @SerializedName("nome")
    val nome: String

)