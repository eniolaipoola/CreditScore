package com.dev.creditScoreApplication.datasource

import com.dev.creditScoreApplication.models.CreditScoreEntity

/**
 * Copyright (c) 2021 Eniola Ipoola
 * All rights reserved
 * Created on 22-Nov-2021
 */
interface CreditScoreIRepository {
    suspend fun fetchRemoteCreditScoreData()

    suspend fun fetchLocalCreditScoreData(): CreditScoreEntity?
}