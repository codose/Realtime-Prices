package com.android.realtime_coinprices.domain.usecase.local

import com.android.realtime_coinprices.data.local.model.TickerEntity
import com.android.realtime_coinprices.data.repository.local.ticker.TickerLocalRepositoryImpl
import com.android.realtime_coinprices.domain.usecase.base.FlowUseCase
import com.android.realtime_coinprices.util.CoroutineContextProvider
import kotlinx.coroutines.flow.Flow
import java.lang.IllegalArgumentException
import javax.inject.Inject

class InsertTickersToDbUseCase @Inject constructor(
    coroutineContextProvider : CoroutineContextProvider,
    private val symbolLocalRepositoryImpl: TickerLocalRepositoryImpl
) : FlowUseCase<TickerEntity, Unit>(coroutineContextProvider) {
    override fun execute(params: TickerEntity?): Flow<Unit> {
        return params?.let { symbolLocalRepositoryImpl.insertTicker(it) } ?: throw IllegalArgumentException("Ticker is null")
    }
}