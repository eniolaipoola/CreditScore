package com.dev.creditscoreapplication.source

import com.dev.creditscoreapplication.models.CreditScoreEntity
import com.dev.creditscoreapplication.source.local.CreditScoreDao
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
    @Inject lateinit var creditScoreDAO: CreditScoreDao
    lateinit var creditScoreData : CreditScoreEntity

    suspend fun fetchRemoteCreditScoreData(){
        withContext(dispatcher){
            creditScoreData = creditScoreService.fetchCreditScore()
            creditScoreDAO.insertAll(creditScoreData)
        }
    }

    suspend fun getCreditScore(): CreditScoreEntity {
        withContext(dispatcher) {
            creditScoreData = creditScoreDAO.getCreditScore()
        }
        return creditScoreData
    }
}