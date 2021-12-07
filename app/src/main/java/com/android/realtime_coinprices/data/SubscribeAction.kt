package com.android.realtime_coinprices.data

import com.google.gson.annotations.SerializedName

data class SubscribeAction(
    @SerializedName("type") val type: String = "subscribe",
    @SerializedName("product_ids") val productIds: List<String>,
    @SerializedName("channels") val channels: List<TickerRequest>
)

data class TickerRequest(
    @SerializedName("name") val name: String = "ticker",
    @SerializedName("product_ids") val productIds: List<String>
)
data class TickerResponse(
    @SerializedName("price") val price: Double
)