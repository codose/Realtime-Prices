package com.android.realtime_coinprices.domain.usecase.local

import com.android.realtime_coinprices.data.local.model.CryptoPairEntity
import com.android.realtime_coinprices.data.repository.local.CryptoPairLocalRepositoryImpl
import com.android.realtime_coinprices.domain.usecase.base.FlowUseCase
import com.android.realtime_coinprices.util.CoroutineContextProvider
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPairsFromDbUseCase @Inject constructor(
    coroutineContextProvider : CoroutineContextProvider,
    private val symbolLocalRepositoryImpl: CryptoPairLocalRepositoryImpl
) : FlowUseCase<Void, List<CryptoPairEntity>>(coroutineContextProvider) {
    override fun execute(params: Void?): Flow<List<CryptoPairEntity>> {
        return symbolLocalRepositoryImpl.getSymbols()
    }
}