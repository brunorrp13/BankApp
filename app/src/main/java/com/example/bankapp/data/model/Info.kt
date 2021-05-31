package com.example.bankapp.data.model


import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("name")
    val name: String,
    @SerializedName("_postman_id")
    val postmanId: String,
    @SerializedName("schema")
    val schema: String
)