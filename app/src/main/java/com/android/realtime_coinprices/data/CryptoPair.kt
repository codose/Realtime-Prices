package com.android.realtime_coinprices.data


import com.google.gson.annotations.SerializedName

data class CryptoPair(
    @SerializedName("base_currency")
    val baseCurrency: String,
    @SerializedName("quote_currency")
    val quoteCurrency: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("display_name")
    val displayName: String,
    @SerializedName("id")
    val id: String
)