package com.android.realtime_coinprices.domain.usecase.observeSocket

import com.android.realtime_coinprices.data.SubscribeAction
import com.android.realtime_coinprices.data.repository.TickerResponse
import com.android.realtime_coinprices.data.repository.socket.CryptoSocketRepositoryImpl
import com.android.realtime_coinprices.domain.usecase.base.FlowUseCase
import com.android.realtime_coinprices.util.CoroutineContextProvider
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCurrentPriceUseCase @Inject constructor(
    coroutineContextProvider : CoroutineContextProvider,
    private val cryptoRepositoryImpl: CryptoSocketRepositoryImpl
) : FlowUseCase<SubscribeAction, TickerResponse>(coroutineContextProvider) {
    override fun execute(params: SubscribeAction?): Flow<TickerResponse> {
        return cryptoRepositoryImpl.getCryptoPrices()
    }
}