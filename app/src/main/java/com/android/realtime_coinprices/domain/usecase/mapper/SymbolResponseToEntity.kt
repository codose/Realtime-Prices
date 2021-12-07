package com.android.realtime_coinprices.domain.usecase.mapper

import com.android.realtime_coinprices.data.Symbol
import com.android.realtime_coinprices.data.local.model.SymbolEntity

object SymbolResponseToEntity {
    fun Symbol.toEntity() : SymbolEntity {
        return SymbolEntity(
            baseAsset = this.baseAsset,
            quoteAsset = this.quoteAsset,
            symbol = this.symbol,
            status = this.status
        )
    }
}