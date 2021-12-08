package com.android.realtime_coinprices.di.modules

import android.content.Context
import androidx.room.Room
import com.android.realtime_coinprices.data.local.CryptoLocalDatabase
import com.android.realtime_coinprices.data.local.dao.CryptoPairDao
import com.android.realtime_coinprices.data.local.dao.TickerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun buildDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, CryptoLocalDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun providePairsDao(dataBase: CryptoLocalDatabase): CryptoPairDao {
        return dataBase.cryptoPairDao()
    }

    @Provides
    @Singleton
    fun provideTickerDao(dataBase: CryptoLocalDatabase): TickerDao {
        return dataBase.tickerDao()
    }

    companion object {
        private const val DATABASE_NAME = "com.android.realtime_crypto_database"
    }
}
