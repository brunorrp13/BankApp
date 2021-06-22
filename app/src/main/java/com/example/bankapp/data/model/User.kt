package com.example.bankapp.data.model

import com.google.gson.annotations.SerializedName

data class User(

    @SerializedName("cpf")
    val username: String,
    @SerializedName("nome")
    val password: String

)