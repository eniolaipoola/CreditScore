package com.dev.creditscoreapplication.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dev.creditscoreapplication.models.CreditScoreEntity

/**
 * Copyright (c) 2021 Eniola Ipoola
 * All rights reserved
 * Created on 14-Nov-2021
 */

@Dao
interface CreditScoreDao {

    @Query("SELECT * FROM credit_score_tbl limit 1")
    fun getCreditScore() : CreditScoreEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(creditScore: CreditScoreEntity)

}