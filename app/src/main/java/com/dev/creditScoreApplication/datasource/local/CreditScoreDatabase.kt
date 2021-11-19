package com.dev.creditScoreApplication.datasource.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dev.creditScoreApplication.BuildConfig
import com.dev.creditScoreApplication.models.CreditScoreEntity

@Database(entities = [CreditScoreEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class CreditScoreDatabase: RoomDatabase() {

    companion object {
        private val DATABASE_NAME = if(BuildConfig.DEBUG) "credit_score_db" else "creditScore_db"
        private var sInstance: CreditScoreDatabase? = null

        fun getInstance(context: Context): CreditScoreDatabase? {
            if(sInstance == null){
                synchronized(CreditScoreDatabase::class.java){
                    sInstance = Room.databaseBuilder(
                        context.applicationContext,
                        CreditScoreDatabase::class.java, DATABASE_NAME
                    ).build()
                }
            }

            return sInstance
        }
    }

    abstract fun creditScoreDao(): CreditScoreDao

}