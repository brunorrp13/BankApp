package com.example.bankapp.data.model

import com.google.gson.annotations.SerializedName

data class Url(
    @SerializedName("host")
    val host: List<String>,
    @SerializedName("path")
    val path: List<String>,
    @SerializedName("protocol")
    val protocol: String,
    @SerializedName("raw")
    val raw: String
)