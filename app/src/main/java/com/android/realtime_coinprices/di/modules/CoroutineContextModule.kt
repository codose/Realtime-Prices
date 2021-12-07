package com.android.realtime_coinprices.di.modules

import com.android.realtime_coinprices.util.CoroutineContextProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class CoroutineContextModule {

    companion object {

        @Provides
        fun provideCoroutineContext(): CoroutineContextProvider {
            return CoroutineContextProvider()
        }
    }
}
