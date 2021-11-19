package com.dev.creditscoreapplication.di

import android.content.Context
import com.dev.creditscoreapplication.datasource.local.CreditScoreDao
import com.dev.creditscoreapplication.datasource.local.CreditScoreDatabase
import com.dev.creditscoreapplication.datasource.local.CreditScoreDatabase.Companion.getInstance
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Copyright (c) 2021 Eniola Ipoola
 * All rights reserved
 * Created on 08-Nov-2021
 */
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