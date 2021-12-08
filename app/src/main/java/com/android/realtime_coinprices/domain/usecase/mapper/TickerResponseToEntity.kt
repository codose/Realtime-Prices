package com.android.realtime_coinprices.domain.usecase.mapper

import com.android.realtime_coinprices.data.local.model.TickerEntity
import com.android.realtime_coinprices.data.repository.TickerResponse

object TickerResponseToEntity {
    fun TickerResponse.toEntity(): TickerEntity {
        return TickerEntity(
            bestAsk = bestAsk,
            bestBid = bestBid,
            high24h = high24h,
            lastSize = lastSize,
            low24h = low24h,
            open24h = open24h,
            price = price,
            productId = productId!!,
            sequence = sequence,
            side = side,
            time = time,
            tradeId = tradeId,
            type = type,
            volume24h = volume24h,
            volume30d = volume30d
        )
    }
}