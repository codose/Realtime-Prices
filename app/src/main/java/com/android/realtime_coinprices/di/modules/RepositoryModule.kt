package com.android.realtime_coinprices.di.modules

import com.android.realtime_coinprices.data.local.dao.SymbolDao
import com.android.realtime_coinprices.data.network.ApiService
import com.android.realtime_coinprices.data.network.SocketService
import com.android.realtime_coinprices.data.repository.api.CryptoApiRepositoryImpl
import com.android.realtime_coinprices.data.repository.local.CryptoSymbolLocalRepositoryImpl
import com.android.realtime_coinprices.data.repository.socket.CryptoSocketRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideAPIRepository(apiService: ApiService): CryptoApiRepositoryImpl {
        return CryptoApiRepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideCryptoRepository(socketService: SocketService) = CryptoSocketRepositoryImpl(socketService)

    @Provides
    @Singleton
    fun provideLocalRepository(symbolDao: SymbolDao) = CryptoSymbolLocalRepositoryImpl(symbolDao)

}