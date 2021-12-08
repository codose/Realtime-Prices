package com.android.realtime_coinprices.data.repository.api

import com.android.realtime_coinprices.data.CryptoPair
import kotlinx.coroutines.flow.Flow

interface CryptoApiRepository {
    fun getPairs(): Flow<List<CryptoPair>>
}