package com.android.realtime_coinprices.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.realtime_coinprices.data.SubscribeAction
import com.android.realtime_coinprices.data.TickerRequest
import com.android.realtime_coinprices.domain.usecase.observeSocket.GetCurrentPriceUseCase
import com.android.realtime_coinprices.domain.usecase.observeSocket.ObserveWebSocketUseCase
import com.android.realtime_coinprices.domain.usecase.observeSocket.SubscribeUseCase
import com.tinder.scarlet.websocket.WebSocketEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCurrentPriceUseCase: GetCurrentPriceUseCase,
    private val subscribeUseCase: SubscribeUseCase,
    private val observeWebSocketUseCase: ObserveWebSocketUseCase
) : ViewModel() {

    init {
        observeSocket()
    }

    private fun observeSocket() {
        viewModelScope.launch {
            observeWebSocketUseCase.execute().collect {
                Timber.e(it.toString())
                when(it){
                    is WebSocketEvent.OnConnectionOpened -> {
                        subscribe()
                    }
                    is WebSocketEvent.OnMessageReceived -> {

                    }
                    is WebSocketEvent.OnConnectionClosing -> {

                    }
                    is WebSocketEvent.OnConnectionClosed -> {

                    }
                    is WebSocketEvent.OnConnectionFailed -> {

                    }
                }
            }
        }
    }

    private suspend fun subscribe() {
        val productIds = listOf("BTC-USDT")
        val tickerRequests = listOf(TickerRequest(productIds = productIds))
        val bitcoinSubscribeAction = SubscribeAction(productIds = productIds, channels = tickerRequests)
        subscribeUseCase.execute(bitcoinSubscribeAction).collect {
            Timber.e("Connection is $it")
        }
    }

    fun observePriceChanges() = getCurrentPriceUseCase.execute()

}