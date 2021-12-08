package com.android.realtime_coinprices.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.realtime_coinprices.data.local.model.SYMBOL_TABLE
import com.android.realtime_coinprices.data.local.model.CryptoPairEntity
import com.android.realtime_coinprices.data.local.model.TICKER_TABLE
import com.android.realtime_coinprices.data.local.model.TickerEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface TickerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTicker(symbols: TickerEntity)

    @Query("SELECT * FROM $TICKER_TABLE")
    fun getTickersAsFlow(): Flow<List<TickerEntity>>
}