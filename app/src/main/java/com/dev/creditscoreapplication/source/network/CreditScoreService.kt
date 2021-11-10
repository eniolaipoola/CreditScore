package com.dev.creditscoreapplication.source.network

import com.dev.creditscoreapplication.models.CreditScoreResponseBody
import retrofit2.http.GET

/**
 * Copyright (c) 2021 Eniola Ipoola
 * All rights reserved
 * Created on 06-Nov-2021
 */
interface CreditScoreService {

    @GET("endpoint.json")
    suspend fun fetchCreditScore(): CreditScoreResponseBody

}