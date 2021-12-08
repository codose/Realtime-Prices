package com.android.realtime_coinprices.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.realtime_coinprices.data.local.model.SYMBOL_TABLE
import com.android.realtime_coinprices.data.local.model.CryptoPairEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface CryptoPairDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPairs(symbols: List<CryptoPairEntity>)

    @Query("SELECT * FROM $SYMBOL_TABLE")
    fun getPairsAsFlow(): Flow<List<CryptoPairEntity>>
}