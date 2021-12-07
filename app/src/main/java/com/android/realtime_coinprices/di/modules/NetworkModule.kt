package com.android.realtime_coinprices.di.modules

import android.app.Application
import android.content.Context
import com.android.realtime_coinprices.data.network.ApiService
import com.android.realtime_coinprices.data.network.SocketService
import com.android.realtime_coinprices.data.repository.api.CryptoApiRepositoryImpl
import com.android.realtime_coinprices.util.CoroutinesFlowStreamAdapterFactory
import com.tinder.scarlet.Lifecycle
import com.tinder.scarlet.Scarlet
import com.tinder.scarlet.lifecycle.android.AndroidLifecycle
import com.tinder.scarlet.messageadapter.gson.GsonMessageAdapter
import com.tinder.scarlet.retry.BackoffStrategy
import com.tinder.scarlet.retry.ExponentialWithJitterBackoffStrategy
import com.tinder.scarlet.websocket.ShutdownReason
import com.tinder.scarlet.websocket.okhttp.OkHttpWebSocket
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {
    private const val SOCKET_BASE_URL = "wss://ws-feed.exchange.coinbase.com"
    private const val API_BASE_URL = "https://api.binance.com/api/v3/"

    @Singleton
    @Provides
    fun provideOkhttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofitService(client: OkHttpClient): ApiService {
        return Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(API_BASE_URL)
            .build()
            .create()
    }

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Singleton
    @Provides
    fun provideLifecycle(@ApplicationContext application : Context) : Lifecycle = AndroidLifecycle.ofApplicationForeground(application as Application)

    @Singleton
    @Provides
    fun provideBackoffStrategy() : BackoffStrategy = ExponentialWithJitterBackoffStrategy(5000, 5000)

    @Singleton
    @Provides
    fun provideScarletService(okHttpClient: OkHttpClient, backoffStrategy: BackoffStrategy, lifecycle: Lifecycle): SocketService {
        return Scarlet(
            protocol = OkHttpWebSocket(okHttpClient, requestFactory = OkHttpWebSocket.SimpleRequestFactory(
                { Request.Builder().url(SOCKET_BASE_URL).build() },
                { ShutdownReason.GRACEFUL }
            )),
            configuration = Scarlet.Configuration(
                messageAdapterFactories = listOf(GsonMessageAdapter.Factory()),
                streamAdapterFactories = listOf(CoroutinesFlowStreamAdapterFactory()),
                backoffStrategy = backoffStrategy,
                lifecycle = lifecycle
            )
        ).create()
    }
}