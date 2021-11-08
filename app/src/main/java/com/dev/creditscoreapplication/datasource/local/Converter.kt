package com.dev.creditscoreapplication.datasource.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Copyright (c) 2021 Eniola Ipoola
 * All rights reserved
 * Created on 08-Nov-2021
 */
class Converter {
    @TypeConverter
    fun fromCreditReport(creditReportInfo: CreditReportInfo): String {
        val gson = Gson()
        return gson.toJson(creditReportInfo)
    }

    @TypeConverter
    fun fromCreditReport(reportId: String): CreditReportInfo {
        val gson = Gson()
        val type = object :
            TypeToken<CreditReportInfo>() {}.type
        return gson.fromJson(reportId, type)
    }
}