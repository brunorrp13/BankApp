package com.example.bankapp.data.model


import com.google.gson.annotations.SerializedName

data class Body(
    @SerializedName("mode")
    val mode: String,
    @SerializedName("urlencoded")
    val urlencoded: List<Urlencoded>
)