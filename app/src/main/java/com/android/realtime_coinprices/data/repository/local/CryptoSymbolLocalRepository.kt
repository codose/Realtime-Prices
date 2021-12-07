package com.android.realtime_coinprices.data.repository.local

import com.android.realtime_coinprices.data.local.model.SymbolEntity
import kotlinx.coroutines.flow.Flow

interface CryptoSymbolLocalRepository {
    fun insertSymbol(symbols: List<SymbolEntity>) : Flow<Unit>
    fun getSymbols() : Flow<List<SymbolEntity>>
}
