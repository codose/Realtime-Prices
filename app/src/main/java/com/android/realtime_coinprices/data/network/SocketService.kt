package com.android.realtime_coinprices.data.network

import com.android.realtime_coinprices.data.SubscribeAction
import com.android.realtime_coinprices.data.repository.TickerResponse
import com.tinder.scarlet.websocket.WebSocketEvent
import com.tinder.scarlet.ws.Receive
import com.tinder.scarlet.ws.Send
import kotlinx.coroutines.flow.Flow

interface SocketService {
    @Send
    fun subscribe(action: SubscribeAction) : Boolean

    @Receive
    fun observeTicker(): Flow<TickerResponse>

    @Receive
    fun observeWebSocketEvent(): Flow<WebSocketEvent>
}