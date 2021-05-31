package com.example.bankapp.data.model


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("name")
    val name: String,
    @SerializedName("request")
    val request: Request,
    @SerializedName("response")
    val response: List<Any>
)