package com.dev.creditscoreapplication.datasource.local

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Copyright (c) 2021 Eniola Ipoola
 * All rights reserved
 * Created on 08-Nov-2021
 */
@Entity
data class CreditScoreEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val accountIDVStatus: String,
    val creditReportInfo: CreditReportInfo,
    val dashboardStatus: String,
    val personaType: String,
    val coachingSummary: String,
    val augmentedCreditScore: Int?,
)

data class CreditReportInfo(
    val score: Int,
    val scoreBand: Int,
)