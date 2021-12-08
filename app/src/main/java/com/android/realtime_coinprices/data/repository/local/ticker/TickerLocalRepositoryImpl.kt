package com.android.realtime_coinprices.data.repository.local.ticker

import com.android.realtime_coinprices.data.local.dao.TickerDao
import com.android.realtime_coinprices.data.local.model.TickerEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TickerLocalRepositoryImpl @Inject constructor(private val tickerDao: TickerDao) : TickerLocalRepository {
    override fun insertTicker(ticker: TickerEntity): Flow<Unit> {
        return flow {
            emit(tickerDao.insertTicker(ticker))
        }
    }

    override fun getTickers(filterOn : String?): Flow<List<TickerEntity>> = tickerDao.getTickersAsFlow().map {
        it.sortedByDescending {
            it.price?.toDoubleOrNull()
        }.filter {
            it.productId.split("-")[1] == filterOn
        }
    }

}
