package com.android.realtime_coinprices.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.realtime_coinprices.data.local.dao.CryptoPairDao
import com.android.realtime_coinprices.data.local.dao.TickerDao
import com.android.realtime_coinprices.data.local.model.CryptoPairEntity
import com.android.realtime_coinprices.data.local.model.TickerEntity

@Database(
    entities = [CryptoPairEntity::class, TickerEntity::class],
    version = 1,
    exportSchema = false
)
abstract class CryptoLocalDatabase : RoomDatabase() {
    abstract fun cryptoPairDao(): CryptoPairDao
    abstract fun tickerDao() : TickerDao
}