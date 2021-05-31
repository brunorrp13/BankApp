package com.example.bankapp.data.model


import com.google.gson.annotations.SerializedName

data class APIResponse(
    @SerializedName("info")
    val info: Info,
    @SerializedName("item")
    val item: List<Item>
)