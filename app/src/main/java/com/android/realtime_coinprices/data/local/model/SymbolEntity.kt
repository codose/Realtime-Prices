package com.android.realtime_coinprices.data.local.model


import androidx.room.Entity
import androidx.room.PrimaryKey

const val SYMBOL_TABLE = "symbol_table"


@Entity(tableName = SYMBOL_TABLE)
data class SymbolEntity(
    val baseAsset: String,
    val quoteAsset: String,
    val status: String,
    @PrimaryKey
    val symbol: String
)