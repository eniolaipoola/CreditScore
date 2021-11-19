package com.dev.creditscoreapplication.datasource

import com.dev.creditscoreapplication.models.CoachingSummary
import com.dev.creditscoreapplication.models.CreditReportInfo
import com.dev.creditscoreapplication.models.CreditScoreEntity
import com.dev.creditscoreapplication.datasource.network.CreditScoreService

/**
 * Copyright (c) 2021 Eniola Ipoola
 * All rights reserved
 * Created on 13-Nov-2021
 */
class FakeRemoteDataSource: CreditScoreService {

    var creditScoreEntity = CreditScoreEntity(
        1, "Pass",
        CreditReportInfo(514, 4, "SED-655426", "MATCH",
            500, 0, -1, false,
            2, true, 45,
            1, 0, 1345,
            1123, 23456,
            34, 345, 4534,
            null, null,
            null,-234, 5,
            -1, 4, "Excellent",
            7), "PASS", "INEXPERIENCED",
        CoachingSummary(false, true,
            0, 0, true ), null
    )

    override suspend fun fetchCreditScoreFromApi(): CreditScoreEntity {
        return creditScoreEntity
    }

}