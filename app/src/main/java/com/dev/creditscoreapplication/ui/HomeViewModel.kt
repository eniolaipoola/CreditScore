package com.dev.creditscoreapplication.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dev.creditscoreapplication.datasource.Repository
import com.dev.creditscoreapplication.models.CreditScoreResponseBody
import com.dev.creditscoreapplication.models.ResultWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Copyright (c) 2021 Eniola Ipoola
 * All rights reserved
 * Created on 09-Nov-2021
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    val repository: Repository): ViewModel() {

    val creditScoreState = MutableLiveData<ResultWrapper<CreditScoreResponseBody>>()

    fun fetchCreditScoreData(){

    }
}