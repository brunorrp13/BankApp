package com.example.bankapp.data.model


import com.google.gson.annotations.SerializedName

data class Request(
    @SerializedName("body")
    val body: Body,
    @SerializedName("header")
    val header: List<Header>,
    @SerializedName("method")
    val method: String,
    @SerializedName("url")
    val url: Url
)