package com.android.realtime_coinprices.data.repository.local

import com.android.realtime_coinprices.data.local.model.CryptoPairEntity
import kotlinx.coroutines.flow.Flow

interface CryptoSymbolLocalRepository {
    fun insertSymbol(symbols: List<CryptoPairEntity>) : Flow<Unit>
    fun getSymbols() : Flow<List<CryptoPairEntity>>
}
