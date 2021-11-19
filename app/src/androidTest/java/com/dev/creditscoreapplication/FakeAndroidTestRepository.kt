
package com.dev.creditscoreapplication

import com.dev.creditscoreapplication.models.CoachingSummary
import com.dev.creditscoreapplication.models.CreditReportInfo
import com.dev.creditscoreapplication.models.CreditScoreEntity

/**
 * Copyright (c) 2021 Eniola Ipoola
 * All rights reserved
 * Created on 14-Nov-2021
 */

class FakeAndroidTestRepository {

    var creditScoreSampleData = CreditScoreEntity(
        1, "Pass",
        CreditReportInfo(514, 4, "SED-655426", "MATCH",
        700, 0, -1, false,
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

}