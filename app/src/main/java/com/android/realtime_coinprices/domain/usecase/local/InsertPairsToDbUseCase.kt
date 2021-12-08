package com.android.realtime_coinprices.domain.usecase.local


import com.android.realtime_coinprices.data.local.model.CryptoPairEntity
import com.android.realtime_coinprices.data.repository.local.CryptoPairLocalRepositoryImpl
import com.android.realtime_coinprices.domain.usecase.base.FlowUseCase
import com.android.realtime_coinprices.util.CoroutineContextProvider
import kotlinx.coroutines.flow.Flow
import java.lang.IllegalArgumentException
import javax.inject.Inject

class InsertPairsToDbUseCase @Inject constructor(
    coroutineContextProvider: CoroutineContextProvider,
    private val cryptoLocalRepositoryImpl: CryptoPairLocalRepositoryImpl
) : FlowUseCase<List<CryptoPairEntity>, Unit>(coroutineContextProvider) {
    override fun execute(params: List<CryptoPairEntity>?): Flow<Unit> {
        return params?.let { cryptoLocalRepositoryImpl.insertSymbol(it) } ?: throw IllegalArgumentException("Pairs is empty")
    }
}