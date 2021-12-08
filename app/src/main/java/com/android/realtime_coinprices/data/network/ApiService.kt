package com.android.realtime_coinprices.data.network

import com.android.realtime_coinprices.data.CryptoPair
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getPairs() : List<CryptoPair>
}