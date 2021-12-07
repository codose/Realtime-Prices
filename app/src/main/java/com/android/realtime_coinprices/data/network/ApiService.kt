package com.android.realtime_coinprices.data.network

import com.android.realtime_coinprices.data.BinancePairsResponse
import com.android.realtime_coinprices.data.SubscribeAction
import com.android.realtime_coinprices.data.TickerResponse
import com.tinder.scarlet.websocket.WebSocketEvent
import com.tinder.scarlet.ws.Receive
import com.tinder.scarlet.ws.Send
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("exchangeInfo")
    suspend fun getPairs() : BinancePairsResponse
}