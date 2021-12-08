package com.android.realtime_coinprices.data.repository.local

import com.android.realtime_coinprices.data.local.dao.CryptoPairDao
import com.android.realtime_coinprices.data.local.model.CryptoPairEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

class CryptoPairLocalRepositoryImpl @Inject constructor(private val symbolDao: CryptoPairDao) : CryptoSymbolLocalRepository {
    override fun insertSymbol(symbols: List<CryptoPairEntity>) : Flow<Unit>  {
        Timber.e("We are logging this")
        return flow {
            Timber.e("We are logging this too")

            emit(symbolDao.insertPairs(symbols))
        }
    }

    override fun getSymbols(): Flow<List<CryptoPairEntity>> = symbolDao.getPairsAsFlow()

}
