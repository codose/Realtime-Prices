package com.android.realtime_coinprices.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

const val TICKER_TABLE = "ticker_table_entity"

@Entity(tableName = TICKER_TABLE)
data class TickerEntity(
    val bestAsk: String?,
    val bestBid: String?,
    val high24h: String?,
    val lastSize: String?,
    val low24h: String?,
    val open24h: String?,
    val price: String?,
    @PrimaryKey
    val productId: String,
    val sequence: Long?,
    val side: String?,
    val time: String?,
    val tradeId: Int?,
    val type: String?,
    val volume24h: String?,
    val volume30d: String?
)