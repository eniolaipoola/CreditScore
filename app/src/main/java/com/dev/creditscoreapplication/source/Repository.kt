package com.dev.creditscoreapplication.source

import com.dev.creditscoreapplication.models.CreditScoreResponseBody
import com.dev.creditscoreapplication.source.network.CreditScoreService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Copyright (c) 2021 Eniola Ipoola
 * All rights reserved
 * Created on 06-Nov-2021
 */
class Repository @Inject constructor(
    private val dispatcher: CoroutineDispatcher) {

    @Inject lateinit var creditScoreService: CreditScoreService

    suspend fun fetchCreditScoreData(): CreditScoreResponseBody{
        return withContext(dispatcher){
            creditScoreService.fetchCreditScore()
        }
    }
}