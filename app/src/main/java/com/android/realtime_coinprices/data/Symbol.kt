package com.android.realtime_coinprices.data


import com.google.gson.annotations.SerializedName

data class Symbol(
    @SerializedName("baseAsset")
    val baseAsset: String,
    @SerializedName("quoteAsset")
    val quoteAsset: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("symbol")
    val symbol: String
)