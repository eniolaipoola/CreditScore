package com.dev.creditscoreapplication.datasource.network

import com.dev.creditscoreapplication.models.CreditScoreEntity
import retrofit2.http.GET

/**
 * Interface to the data layer
 */
interface CreditScoreService {

    @GET("endpoint.json")
    suspend fun fetchCreditScoreFromApi(): CreditScoreEntity

}