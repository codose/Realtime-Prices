package com.android.realtime_coinprices.data.local
import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.realtime_coinprices.data.local.dao.SymbolDao
import com.android.realtime_coinprices.data.local.model.SymbolEntity

@Database(
    entities = [SymbolEntity::class],
    version = 1,
    exportSchema = false
)
abstract class CryptoLocalDatabase : RoomDatabase() {
    abstract fun symbolDao(): SymbolDao
}