package com.dev.creditscoreapplication.source.network

import androidx.lifecycle.LiveData
import com.dev.creditscoreapplication.models.CreditScoreEntity
import retrofit2.http.GET
import com.dev.creditscoreapplication.models.Result

/**
 * Interface to the data layer
 */
interface CreditScoreService {

    @GET("endpoint.json")
    suspend fun fetchCreditScore(): CreditScoreEntity

    //methods implemented for testing purposes
    fun observeCreditScoreResult(): LiveData<Result<CreditScoreEntity>>

}