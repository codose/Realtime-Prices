package com.android.realtime_coinprices.data


import com.google.gson.annotations.SerializedName

data class BinancePairsResponse(
    @SerializedName("serverTime")
    val serverTime: Long,
    @SerializedName("symbols")
    val symbols: List<Symbol>,
    @SerializedName("timezone")
    val timezone: String
)