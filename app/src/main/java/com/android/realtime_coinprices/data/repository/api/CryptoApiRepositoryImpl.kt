package com.android.realtime_coinprices.data.repository.api

import com.android.realtime_coinprices.data.BinancePairsResponse
import com.android.realtime_coinprices.data.network.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CryptoApiRepositoryImpl @Inject constructor(private val apiService: ApiService) : CryptoApiRepository {
    override fun getPairs(): Flow<BinancePairsResponse> = flow {
        emit(apiService.getPairs())
    }
}