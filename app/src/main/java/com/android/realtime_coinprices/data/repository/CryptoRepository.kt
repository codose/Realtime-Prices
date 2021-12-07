package com.android.realtime_coinprices.data.repository

import com.android.realtime_coinprices.data.SubscribeAction
import com.android.realtime_coinprices.data.TickerResponse
import com.tinder.scarlet.Event
import com.tinder.scarlet.websocket.WebSocketEvent
import kotlinx.coroutines.flow.Flow

interface CryptoRepository {
    fun getCryptoPrices() : Flow<TickerResponse>

    fun observeWebSocket() : Flow<WebSocketEvent>

    fun subscribe(action: SubscribeAction): Flow<Boolean>
}