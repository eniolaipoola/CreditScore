package com.dev.creditscoreapplication.di

import com.dev.creditscoreapplication.BuildConfig
import com.dev.creditscoreapplication.datasource.network.CreditScoreService
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Copyright (c) 2021 Eniola Ipoola
 * All rights reserved
 * Created on 06-Nov-2021
 */
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    companion object {
        const val BASE_URL = "https://android-interview.s3.eu-west-2.amazonaws.com/"
    }

    @Provides
    fun provideIODispatcher() = Dispatchers.IO

    @Provides
    fun provideRetrofit(loggingInterceptor: HttpLoggingInterceptor): Retrofit {
        val gson = GsonBuilder().setLenient().create()
        val httpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    fun providesLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        if(BuildConfig.DEBUG){
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        } else {
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
        }

        return loggingInterceptor
    }

    @Provides
    @Singleton
    fun provideCreditScoreService(retrofit: Retrofit) : CreditScoreService {
        return retrofit.create(CreditScoreService::class.java)
    }
}