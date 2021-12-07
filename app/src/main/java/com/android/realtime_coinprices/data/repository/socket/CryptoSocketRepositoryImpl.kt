package com.android.realtime_coinprices.data.repository.socket

import com.android.realtime_coinprices.data.SubscribeAction
import com.android.realtime_coinprices.data.TickerResponse
import com.android.realtime_coinprices.data.network.SocketService
import com.tinder.scarlet.websocket.WebSocketEvent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CryptoSocketRepositoryImpl @Inject constructor(private val socketService: SocketService) : CryptoSocketRepository {

    override fun getCryptoPrices(): Flow<TickerResponse> = socketService.observeTicker()

    override fun observeWebSocket(): Flow<WebSocketEvent> {
        val event = socketService.observeWebSocketEvent()
        return event
    }


    override fun subscribe(action: SubscribeAction) = flow {
        emit(socketService.subscribe(action))
    }


}