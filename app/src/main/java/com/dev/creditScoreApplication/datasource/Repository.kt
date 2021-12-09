package com.dev.creditScoreApplication.datasource

import com.dev.creditScoreApplication.models.CreditScoreEntity
import com.dev.creditScoreApplication.datasource.local.CreditScoreDao
import com.dev.creditScoreApplication.datasource.network.CreditScoreService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class Repository @Inject constructor(
    private val dispatcher: CoroutineDispatcher,
    private val creditScoreService: CreditScoreService,
    private val creditScoreDAO: CreditScoreDao) : CreditScoreIRepository {

    private var creditScoreData : CreditScoreEntity? = null

    override suspend fun fetchRemoteCreditScoreData() {
        withContext(dispatcher){
            val data = creditScoreService.fetchCreditScoreFromApi()
            creditScoreDAO.insertAll(data)
        }
    }

    override suspend fun fetchLocalCreditScoreData(): CreditScoreEntity? {
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