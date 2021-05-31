package com.example.bankapp.data.model


import com.google.gson.annotations.SerializedName

data class Urlencoded(
    @SerializedName("key")
    val key: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("value")
    val value: String
)