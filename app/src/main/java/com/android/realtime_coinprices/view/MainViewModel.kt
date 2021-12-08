package com.android.realtime_coinprices.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.realtime_coinprices.data.SubscribeAction
import com.android.realtime_coinprices.data.TickerRequest
import com.android.realtime_coinprices.data.local.model.CryptoPairEntity
import com.android.realtime_coinprices.domain.usecase.api.GetPairsUseCase
import com.android.realtime_coinprices.domain.usecase.local.GetPairsFromDbUseCase
import com.android.realtime_coinprices.domain.usecase.local.GetTickersFromDbUseCase
import com.android.realtime_coinprices.domain.usecase.local.InsertPairsToDbUseCase
import com.android.realtime_coinprices.domain.usecase.local.InsertTickersToDbUseCase
import com.android.realtime_coinprices.domain.usecase.mapper.CryptoPairToEntity.toEntity
import com.android.realtime_coinprices.domain.usecase.mapper.TickerResponseToEntity.toEntity
import com.android.realtime_coinprices.domain.usecase.observeSocket.GetCurrentPriceUseCase
import com.android.realtime_coinprices.domain.usecase.observeSocket.ObserveWebSocketUseCase
import com.android.realtime_coinprices.domain.usecase.observeSocket.SubscribeUseCase
import com.tinder.scarlet.websocket.WebSocketEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.buffer
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
    private val getPairsFromDbUseCase: GetPairsFromDbUseCase,
    private val insertPairsToDbUseCase: InsertPairsToDbUseCase,
    private val getTickerFromDbUseCase: GetTickersFromDbUseCase,
    private val insertTickersToDbUseCase: InsertTickersToDbUseCase
) : ViewModel() {

    init {
        getCryptoPairs()
        observeSocket()
        getPairsFromDb()
    }

    private val hasConnected = MutableStateFlow(false)

    private fun observeSocket() {
        viewModelScope.launch {
            observeWebSocketUseCase.execute().collect {
                when (it) {
                    is WebSocketEvent.OnConnectionOpened -> {
                        hasConnected.value = true
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

    private fun getPairsFromDb() {
        viewModelScope.launch {
            getPairsFromDbUseCase.execute().collect { list ->
                hasConnected.collect {
                    if (it) {
                        subscribe(list)
                    }
                }
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
                val pairEntities = it.map {
                    it.toEntity()
                }
                insertPairsToDbUseCase
                    .execute(pairEntities)
                    .flowOn(Dispatchers.IO)
                    .collect {}
            }
        }
    }

    private suspend fun subscribe(list: List<CryptoPairEntity>) {
        val productIds = list.map { it.id }
        val tickerRequests = listOf(TickerRequest(productIds = productIds))
        val bitcoinSubscribeAction = SubscribeAction(productIds = productIds, channels = tickerRequests)
        subscribeUseCase.execute(bitcoinSubscribeAction).collect {
            Timber.e("Connection is $it")
            observePriceChanges()
        }
    }

    private fun observePriceChanges() {
        viewModelScope.launch {
            getCurrentPriceUseCase.execute().collect {
                Timber.e(it.toString())
                it.productId?.let { pr ->
                    insertTickersToDbUseCase
                        .execute(it.toEntity())
                        .flowOn(Dispatchers.IO)
                        .collect {}
                }
            }
        }
    }

    fun getTickersFromDb() = getTickerFromDbUseCase.execute("USDT").buffer(capacity = 500)


}