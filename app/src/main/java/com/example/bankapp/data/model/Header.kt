package com.example.bankapp.data.model


import com.google.gson.annotations.SerializedName

data class Header(
    @SerializedName("key")
    val key: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("value")
    val value: String
)