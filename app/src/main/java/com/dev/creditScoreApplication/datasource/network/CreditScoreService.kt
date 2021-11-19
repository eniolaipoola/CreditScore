package com.dev.creditScoreApplication.datasource.network

import com.dev.creditScoreApplication.models.CreditScoreEntity
import retrofit2.http.GET

/**
 * Interface to the data layer
 */
interface CreditScoreService {

    @GET("endpoint.json")
    suspend fun fetchCreditScoreFromApi(): CreditScoreEntity

}