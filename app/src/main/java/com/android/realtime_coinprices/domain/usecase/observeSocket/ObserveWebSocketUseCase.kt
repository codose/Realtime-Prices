package com.android.realtime_coinprices.domain.usecase.observeSocket

import com.android.realtime_coinprices.data.repository.CryptoRepositoryImpl
import com.android.realtime_coinprices.domain.usecase.base.FlowUseCase
import com.android.realtime_coinprices.util.CoroutineContextProvider
import com.tinder.scarlet.Event
import com.tinder.scarlet.websocket.WebSocketEvent
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ObserveWebSocketUseCase @Inject constructor(
    coroutineContextProvider : CoroutineContextProvider,
    private val cryptoRepositoryImpl: CryptoRepositoryImpl
) : FlowUseCase<String, WebSocketEvent>(coroutineContextProvider) {
    override fun execute(params: String?): Flow<WebSocketEvent> {
        return cryptoRepositoryImpl.observeWebSocket()
    }
}