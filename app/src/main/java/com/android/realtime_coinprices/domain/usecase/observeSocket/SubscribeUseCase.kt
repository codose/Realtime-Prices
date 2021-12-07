package com.android.realtime_coinprices.domain.usecase.observeSocket

import com.android.realtime_coinprices.data.SubscribeAction
import com.android.realtime_coinprices.data.repository.CryptoRepositoryImpl
import com.android.realtime_coinprices.domain.usecase.base.FlowUseCase
import com.android.realtime_coinprices.util.CoroutineContextProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.IllegalArgumentException
import javax.inject.Inject

class SubscribeUseCase @Inject constructor(
    coroutineContextProvider : CoroutineContextProvider,
    private val cryptoRepositoryImpl: CryptoRepositoryImpl
) : FlowUseCase<SubscribeAction, Boolean>(coroutineContextProvider) {
    override fun execute(params: SubscribeAction?): Flow<Boolean> {
        return params?.let { cryptoRepositoryImpl.subscribe(it) } ?: throw IllegalArgumentException("No Action")
    }

}