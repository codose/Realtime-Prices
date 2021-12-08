package com.android.realtime_coinprices.data.repository.local.ticker

import com.android.realtime_coinprices.data.local.model.CryptoPairEntity
import com.android.realtime_coinprices.data.local.model.TickerEntity
import kotlinx.coroutines.flow.Flow

interface TickerLocalRepository {
    fun insertTicker(ticker: TickerEntity) : Flow<Unit>
    fun getTickers(filterOn : String?) : Flow<List<TickerEntity>>
}
