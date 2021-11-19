package com.dev.creditScoreApplication.di

import android.content.Context
import com.dev.creditScoreApplication.datasource.local.CreditScoreDao
import com.dev.creditScoreApplication.datasource.local.CreditScoreDatabase
import com.dev.creditScoreApplication.datasource.local.CreditScoreDatabase.Companion.getInstance
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
    fun providesRoomDatabase(@ApplicationContext context: Context): CreditScoreDatabase {
        return getInstance(context)!!
    }

    @Provides
    fun providesDao(database: CreditScoreDatabase): CreditScoreDao {
        return database.creditScoreDao()
    }
}