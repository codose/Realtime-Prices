package com.android.realtime_coinprices.data.repository


import com.google.gson.annotations.SerializedName

data class TickerResponse(
    @SerializedName("best_ask")
    val bestAsk: String?,
    @SerializedName("best_bid")
    val bestBid: String?,
    @SerializedName("high_24h")
    val high24h: String?,
    @SerializedName("last_size")
    val lastSize: String?,
    @SerializedName("low_24h")
    val low24h: String?,
    @SerializedName("open_24h")
    val open24h: String?,
    @SerializedName("price")
    val price: String?,
    @SerializedName("product_id")
    val productId: String?,
    @SerializedName("sequence")
    val sequence: Long?,
    @SerializedName("side")
    val side: String?,
    @SerializedName("time")
    val time: String?,
    @SerializedName("trade_id")
    val tradeId: Int?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("volume_24h")
    val volume24h: String?,
    @SerializedName("volume_30d")
    val volume30d: String?
)