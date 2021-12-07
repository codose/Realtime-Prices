package com.android.realtime_coinprices.di.modules

import com.android.realtime_coinprices.data.network.SocketService
import com.android.realtime_coinprices.data.repository.CryptoRepositoryImpl
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
        cryptoRepositoryImpl: CryptoRepositoryImpl,
    ) = GetCurrentPriceUseCase(coroutineContextProvider, cryptoRepositoryImpl)


    @Provides
    @Singleton
    fun provideObserveSocketUseCase(
        coroutineContextProvider: CoroutineContextProvider,
        cryptoRepositoryImpl: CryptoRepositoryImpl,
    ) = ObserveWebSocketUseCase(coroutineContextProvider, cryptoRepositoryImpl)

    @Provides
    @Singleton
    fun provideSubscribeUseCase(
        coroutineContextProvider: CoroutineContextProvider,
        cryptoRepositoryImpl: CryptoRepositoryImpl,
    ) = SubscribeUseCase(coroutineContextProvider, cryptoRepositoryImpl)

    @Provides
    @Singleton
    fun provideCryptoRepository(socketService: SocketService) = CryptoRepositoryImpl(socketService)

}