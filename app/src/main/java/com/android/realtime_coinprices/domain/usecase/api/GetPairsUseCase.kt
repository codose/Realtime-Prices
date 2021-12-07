package com.android.realtime_coinprices.domain.usecase.api

import com.android.realtime_coinprices.data.BinancePairsResponse
import com.android.realtime_coinprices.data.SubscribeAction
import com.android.realtime_coinprices.data.TickerResponse
import com.android.realtime_coinprices.data.repository.api.CryptoApiRepositoryImpl
import com.android.realtime_coinprices.data.repository.socket.CryptoSocketRepositoryImpl
import com.android.realtime_coinprices.domain.usecase.base.FlowUseCase
import com.android.realtime_coinprices.util.CoroutineContextProvider
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPairsUseCase @Inject constructor(
    coroutineContextProvider : CoroutineContextProvider,
    private val cryptoApiRepositoryImpl: CryptoApiRepositoryImpl
) : FlowUseCase<Void, BinancePairsResponse>(coroutineContextProvider) {
    override fun execute(params: Void?): Flow<BinancePairsResponse> {
        return cryptoApiRepositoryImpl.getPairs()
    }
}