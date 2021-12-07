package com.android.realtime_coinprices.domain.usecase.local


import com.android.realtime_coinprices.data.local.model.SymbolEntity
import com.android.realtime_coinprices.data.repository.local.CryptoSymbolLocalRepositoryImpl
import com.android.realtime_coinprices.domain.usecase.base.FlowUseCase
import com.android.realtime_coinprices.util.CoroutineContextProvider
import kotlinx.coroutines.flow.Flow
import java.lang.IllegalArgumentException
import javax.inject.Inject

class InsertSymbolsToDbUseCase @Inject constructor(
    coroutineContextProvider: CoroutineContextProvider,
    private val cryptoLocalRepositoryImpl: CryptoSymbolLocalRepositoryImpl
) : FlowUseCase<List<SymbolEntity>, Unit>(coroutineContextProvider) {
    override fun execute(params: List<SymbolEntity>?): Flow<Unit> {
        return params?.let { cryptoLocalRepositoryImpl.insertSymbol(it) } ?: throw IllegalArgumentException("Symbols is empty")
    }
}