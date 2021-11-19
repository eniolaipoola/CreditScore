package com.dev.creditScoreApplication.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dev.creditScoreApplication.models.CreditScoreEntity

@Dao
interface CreditScoreDao {

    @Query("SELECT * FROM credit_score_tbl limit 1")
    fun getCreditScoreFromDatabase() : CreditScoreEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(creditScore: CreditScoreEntity)

}