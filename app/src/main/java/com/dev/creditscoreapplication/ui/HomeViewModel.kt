package com.dev.creditscoreapplication.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.creditscoreapplication.datasource.Repository
import com.dev.creditscoreapplication.models.CreditScoreEntity
import com.dev.creditscoreapplication.models.Result
import com.dev.creditscoreapplication.utils.exceptionHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Copyright (c) 2021 Eniola Ipoola
 * All rights reserved
 * Created on 09-Nov-2021
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository): ViewModel() {

    val creditScoreState = MutableLiveData<Result<CreditScoreEntity>>()

    fun getCreditScoreData() {
        viewModelScope.launch {
            creditScoreState.postValue(Result.Loading(true))
            val result = repository.fetchLocalCreditScoreData()
            if(result != null){
                creditScoreState.postValue(Result.Success(result))
            }
        }
    }

    fun fetchRemoteCreditScoreData(){
        viewModelScope.launch(exceptionHandler(creditScoreState)) {
            creditScoreState.postValue(Result.Loading(true))
            repository.fetchRemoteCreditScoreData()
            getCreditScoreData()
        }
    }

}