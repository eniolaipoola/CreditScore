package com.dev.creditscoreapplication.datasource

import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class RepositoryTest {

    lateinit var repository : Repository
    private lateinit var fakeCreditScoreService : FakeRemoteDataSource
    private lateinit var fakeCreditScoreDao : FakeLocalDataSource

    @Before
    fun createRepository(){
        fakeCreditScoreService = FakeRemoteDataSource()
        fakeCreditScoreDao = FakeLocalDataSource()
        repository = Repository(Dispatchers.Unconfined, fakeCreditScoreService, fakeCreditScoreDao)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getCreditScore_creditScoreDataFromRemoteDataSource_isNotNull() = runBlocking {
        val creditScoreData = repository.fetchRemoteCreditScoreData()
        assertNotNull(creditScoreData)
    }

    @Test
    fun getCreditScore_requestCreditScoreDataFromLocalDataSource() = runBlocking {
        //original repository method that fetches localCreditScoreData
        val creditScoreData = repository.fetchLocalCreditScoreData()
        assertNotNull(creditScoreData)

        //fake repository method that fetches localCreditScoreData
        val fakeCreditScoreData = fakeCreditScoreDao.getCreditScoreFromDatabase()
        assertNotNull(fakeCreditScoreData)

        assertEquals(creditScoreData, fakeCreditScoreData)
    }

}