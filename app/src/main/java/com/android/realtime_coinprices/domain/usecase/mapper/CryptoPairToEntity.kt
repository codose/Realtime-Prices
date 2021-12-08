package com.android.realtime_coinprices.domain.usecase.mapper

import com.android.realtime_coinprices.data.CryptoPair
import com.android.realtime_coinprices.data.local.model.CryptoPairEntity

object CryptoPairToEntity {
    fun CryptoPair.toEntity(): CryptoPairEntity {
        return CryptoPairEntity(
            baseCurrency = baseCurrency,
            quoteCurrency = quoteCurrency,
            status = status,
            displayName = displayName,
            id = id
        )
    }
}