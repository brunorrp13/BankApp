package com.example.bankapp.data.model

import com.google.gson.annotations.SerializedName


data class ExtratoAPIResponse (
    @SerializedName("items")
    val items: List<ExtratoItem>
)