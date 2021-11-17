package com.dev.creditscoreapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import com.dev.creditscoreapplication.models.CoachingSummary
import com.dev.creditscoreapplication.models.CreditReportInfo
import com.dev.creditscoreapplication.models.CreditScoreEntity
import com.dev.creditscoreapplication.source.network.CreditScoreService
import com.dev.creditscoreapplication.models.Result

/**
 * Copyright (c) 2021 Eniola Ipoola
 * All rights reserved
 * Created on 14-Nov-2021
 */
class FakeAndroidTestRepository: CreditScoreService {

    private val observableCreditScoreData = MutableLiveData<Result<CreditScoreEntity>>()

    var creditScoreSampleData = CreditScoreEntity(
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
            7),"PASS", "INEXPERIENCED",
        CoachingSummary(false, true,
            0, 0, true ),
        null
    )

    override fun observeCreditScoreResult(): LiveData<Result<CreditScoreEntity>> {
        return observableCreditScoreData.map { scoreData ->
            when(scoreData) {
                is Result.Loading  -> scoreData.loading
                is Result.Success -> {
                    val data = scoreData.value
                }
                is Result.Error -> scoreData.error

            } as Result<CreditScoreEntity>
        }
    }

    override suspend fun fetchCreditScore(): CreditScoreEntity {
        return creditScoreSampleData
    }


}