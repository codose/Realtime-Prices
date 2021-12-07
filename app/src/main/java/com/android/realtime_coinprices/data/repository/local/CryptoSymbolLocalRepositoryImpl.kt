package com.android.realtime_coinprices.data.repository.local

import com.android.realtime_coinprices.data.local.dao.SymbolDao
import com.android.realtime_coinprices.data.local.model.SymbolEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

class CryptoSymbolLocalRepositoryImpl @Inject constructor(private val symbolDao: SymbolDao) : CryptoSymbolLocalRepository {
    override fun insertSymbol(symbols: List<SymbolEntity>) : Flow<Unit>  {
        Timber.e("We are logging this")
        return flow {
            Timber.e("We are logging this too")

            emit(symbolDao.saveSymbolPairs(symbols))
        }
    }

    override fun getSymbols(): Flow<List<SymbolEntity>> = symbolDao.getPairsAsFlow()

}
