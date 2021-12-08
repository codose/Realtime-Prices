package com.android.realtime_coinprices.di.modules

import com.android.realtime_coinprices.data.repository.api.CryptoApiRepositoryImpl
import com.android.realtime_coinprices.data.repository.local.CryptoPairLocalRepositoryImpl
import com.android.realtime_coinprices.data.repository.local.ticker.TickerLocalRepositoryImpl
import com.android.realtime_coinprices.data.repository.socket.CryptoSocketRepositoryImpl
import com.android.realtime_coinprices.domain.usecase.api.GetPairsUseCase
import com.android.realtime_coinprices.domain.usecase.local.GetPairsFromDbUseCase
import com.android.realtime_coinprices.domain.usecase.local.GetTickersFromDbUseCase
import com.android.realtime_coinprices.domain.usecase.local.InsertPairsToDbUseCase
import com.android.realtime_coinprices.domain.usecase.local.InsertTickersToDbUseCase
import com.android.realtime_coinprices.domain.usecase.observeSocket.GetCurrentPriceUseCase
import com.android.realtime_coinprices.domain.usecase.observeSocket.ObserveWebSocketUseCase
import com.android.realtime_coinprices.domain.usecase.observeSocket.SubscribeUseCase
import com.android.realtime_coinprices.util.CoroutineContextProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideGetPriceUseCase(
        coroutineContextProvider: CoroutineContextProvider,
        cryptoRepositoryImpl: CryptoSocketRepositoryImpl,
    ) = GetCurrentPriceUseCase(coroutineContextProvider, cryptoRepositoryImpl)


    @Provides
    @Singleton
    fun provideObserveSocketUseCase(
        coroutineContextProvider: CoroutineContextProvider,
        cryptoRepositoryImpl: CryptoSocketRepositoryImpl,
    ) = ObserveWebSocketUseCase(coroutineContextProvider, cryptoRepositoryImpl)

    @Provides
    @Singleton
    fun provideSubscribeUseCase(
        coroutineContextProvider: CoroutineContextProvider,
        cryptoRepositoryImpl: CryptoSocketRepositoryImpl,
    ) = SubscribeUseCase(coroutineContextProvider, cryptoRepositoryImpl)

    @Provides
    @Singleton
    fun provideCryptoApiUseCase(
        coroutineContextProvider: CoroutineContextProvider,
        cryptoApiRepositoryImpl: CryptoApiRepositoryImpl,
    ) = GetPairsUseCase(coroutineContextProvider, cryptoApiRepositoryImpl)

    @Provides
    @Singleton
    fun provideGetPairsUseCase(
        coroutineContextProvider: CoroutineContextProvider,
        symbolLocalRepositoryImpl: CryptoPairLocalRepositoryImpl,
    ) = GetPairsFromDbUseCase(coroutineContextProvider, symbolLocalRepositoryImpl)

    @Provides
    @Singleton
    fun provideInsertPairsUseCase(
        coroutineContextProvider: CoroutineContextProvider,
        symbolLocalRepositoryImpl: CryptoPairLocalRepositoryImpl,
    ) = InsertPairsToDbUseCase(coroutineContextProvider, symbolLocalRepositoryImpl)

    @Provides
    @Singleton
    fun provideGetTickersUseCase(
        coroutineContextProvider: CoroutineContextProvider,
        tickerLocalRepositoryImpl: TickerLocalRepositoryImpl
    ) = GetTickersFromDbUseCase(coroutineContextProvider, tickerLocalRepositoryImpl)

    @Provides
    @Singleton
    fun provideInsertTickersUseCase(
        coroutineContextProvider: CoroutineContextProvider,
        tickerLocalRepositoryImpl: TickerLocalRepositoryImpl
    ) = InsertTickersToDbUseCase(coroutineContextProvider, tickerLocalRepositoryImpl)
}