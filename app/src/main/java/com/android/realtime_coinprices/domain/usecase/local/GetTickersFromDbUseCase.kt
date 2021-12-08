package com.android.realtime_coinprices.domain.usecase.local

import com.android.realtime_coinprices.data.local.model.TickerEntity
import com.android.realtime_coinprices.data.repository.local.ticker.TickerLocalRepositoryImpl
import com.android.realtime_coinprices.domain.usecase.base.FlowUseCase
import com.android.realtime_coinprices.util.CoroutineContextProvider
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTickersFromDbUseCase @Inject constructor(
    coroutineContextProvider : CoroutineContextProvider,
    private val symbolLocalRepositoryImpl: TickerLocalRepositoryImpl
) : FlowUseCase<String, List<TickerEntity>>(coroutineContextProvider) {
    override fun execute(params: String?): Flow<List<TickerEntity>> {
        return symbolLocalRepositoryImpl.getTickers(filterOn = params)
    }
}