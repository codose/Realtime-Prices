package com.android.realtime_coinprices.domain.usecase.local

import com.android.realtime_coinprices.data.local.model.SymbolEntity
import com.android.realtime_coinprices.data.repository.local.CryptoSymbolLocalRepositoryImpl
import com.android.realtime_coinprices.domain.usecase.base.FlowUseCase
import com.android.realtime_coinprices.util.CoroutineContextProvider
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSymbolsFromDbUseCase @Inject constructor(
    coroutineContextProvider : CoroutineContextProvider,
    private val symbolLocalRepositoryImpl: CryptoSymbolLocalRepositoryImpl
) : FlowUseCase<Void, List<SymbolEntity>>(coroutineContextProvider) {
    override fun execute(params: Void?): Flow<List<SymbolEntity>> {
        return symbolLocalRepositoryImpl.getSymbols()
    }
}