package com.android.realtime_coinprices.data.local.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

const val SYMBOL_TABLE = "crypto_pair_table"


@Entity(tableName = SYMBOL_TABLE)
data class CryptoPairEntity(
    val baseCurrency: String,
    val quoteCurrency: String,
    val status: String,
    val displayName: String,
    @PrimaryKey
    val id: String
)