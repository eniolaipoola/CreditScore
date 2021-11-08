package com.dev.creditscoreapplication.datasource.local

import android.content.Context
import com.dev.creditscoreapplication.datasource.local.CreditScoreDatabase.Companion.getInstance
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Copyright (c) 2021 Eniola Ipoola
 * All rights reserved
 * Created on 08-Nov-2021
 */
@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun providesRoomDatabase(context: Context): CreditScoreDatabase {
        return getInstance(context)!!
    }
}