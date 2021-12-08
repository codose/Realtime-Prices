package com.android.realtime_coinprices.data.repository.socket

import com.android.realtime_coinprices.data.SubscribeAction
import com.android.realtime_coinprices.data.repository.TickerResponse
import com.tinder.scarlet.websocket.WebSocketEvent
import kotlinx.coroutines.flow.Flow

interface CryptoSocketRepository {
    fun getCryptoPrices() : Flow<TickerResponse>

    fun observeWebSocket() : Flow<WebSocketEvent>

    fun subscribe(action: SubscribeAction): Flow<Boolean>
}