package com.dev.creditScoreApplication.datasource

import com.dev.creditScoreApplication.models.CreditScoreEntity
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class RepositoryTest: CreditScoreIRepository {

    lateinit var repository : Repository
    private lateinit var fakeRemoteData : FakeRemoteDataSource
    private lateinit var fakeLocalData : FakeLocalDataSource

    @Before
    fun createRepository(){
        fakeRemoteData = FakeRemoteDataSource()
        fakeLocalData = FakeLocalDataSource()
        repository = Repository(Dispatchers.Unconfined, fakeRemoteData, fakeLocalData)
    }

    @Test
    fun getCreditScore_creditScoreDataFromRemoteDataSource_isNotNull() = runBlockingTest {
        val creditScoreData = repository.fetchRemoteCreditScoreData()
        assertNotNull(creditScoreData)
    }

    @Test
    fun getCreditScore_requestCreditScoreDataFromLocalDataSource() = runBlockingTest {
        //original repository method that fetches localCreditScoreData
        val creditScoreData = repository.fetchLocalCreditScoreData()
        assertNotNull(creditScoreData)

        //fake repository method that fetches localCreditScoreData
        val fakeCreditScoreData = fakeLocalData.getCreditScoreFromDatabase()
        assertNotNull(fakeCreditScoreData)

        assertEquals(creditScoreData, fakeCreditScoreData)
    }

    override suspend fun fetchRemoteCreditScoreData() {
        repository.fetchRemoteCreditScoreData()
    }

    override suspend fun fetchLocalCreditScoreData(): CreditScoreEntity {
        //return data fetched
        return fakeLocalData.creditScoreEntity
    }


}