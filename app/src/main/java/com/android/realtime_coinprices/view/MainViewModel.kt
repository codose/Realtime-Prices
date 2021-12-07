package com.android.realtime_coinprices.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.realtime_coinprices.data.SubscribeAction
import com.android.realtime_coinprices.data.TickerRequest
import com.android.realtime_coinprices.domain.usecase.api.GetPairsUseCase
import com.android.realtime_coinprices.domain.usecase.local.GetSymbolsFromDbUseCase
import com.android.realtime_coinprices.domain.usecase.local.InsertSymbolsToDbUseCase
import com.android.realtime_coinprices.domain.usecase.mapper.SymbolResponseToEntity.toEntity
import com.android.realtime_coinprices.domain.usecase.observeSocket.GetCurrentPriceUseCase
import com.android.realtime_coinprices.domain.usecase.observeSocket.ObserveWebSocketUseCase
import com.android.realtime_coinprices.domain.usecase.observeSocket.SubscribeUseCase
import com.tinder.scarlet.websocket.WebSocketEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCurrentPriceUseCase: GetCurrentPriceUseCase,
    private val subscribeUseCase: SubscribeUseCase,
    private val observeWebSocketUseCase: ObserveWebSocketUseCase,
    private val getPairsUseCase: GetPairsUseCase,
    private val getSymbolsFromDbUseCase: GetSymbolsFromDbUseCase,
    private val insertSymbolsToDbUseCase: InsertSymbolsToDbUseCase
) : ViewModel() {

    init {
        getCryptoPairs()
        observeSocket()
        getSymbolFromDb()
    }

    private fun observeSocket() {
        viewModelScope.launch {
            observeWebSocketUseCase.execute().collect {
                when (it) {
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

    private fun getSymbolFromDb() {
        viewModelScope.launch {
            getSymbolsFromDbUseCase.execute().collect {
                Timber.e(it.toString())
            }
        }
    }


    private fun getCryptoPairs() {
        viewModelScope.launch {
            val data = getPairsUseCase.execute()
                .catch { error ->
                    Timber.e(error)
                }.firstOrNull()
            data?.let {
                val symbolEntities = it.symbols.map {
                    it.toEntity()
                }
                insertSymbolsToDbUseCase
                    .execute(symbolEntities)
                    .flowOn(Dispatchers.IO)
                    .collect {

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