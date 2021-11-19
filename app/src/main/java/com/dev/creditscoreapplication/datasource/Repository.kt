package com.dev.creditscoreapplication.datasource

import com.dev.creditscoreapplication.models.CreditScoreEntity
import com.dev.creditscoreapplication.datasource.local.CreditScoreDao
import com.dev.creditscoreapplication.datasource.network.CreditScoreService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Copyright (c) 2021 Eniola Ipoola
 * All rights reserved
 * Created on 06-Nov-2021
 */
class Repository @Inject constructor(
    private val dispatcher: CoroutineDispatcher,
    private val creditScoreService: CreditScoreService,
    private val creditScoreDAO: CreditScoreDao) {

    private var creditScoreData : CreditScoreEntity? = null

    suspend fun fetchRemoteCreditScoreData() {
        withContext(dispatcher){
            val data = creditScoreService.fetchCreditScoreFromApi()
            creditScoreDAO.insertAll(data)
        }
    }

    suspend fun fetchLocalCreditScoreData(): CreditScoreEntity? {
        withContext(dispatcher) {
            creditScoreData = creditScoreDAO.getCreditScoreFromDatabase()
            if(creditScoreData == null) {
                //fetch from remote
                fetchRemoteCreditScoreData()
            }
        }
        return creditScoreData
    }
}