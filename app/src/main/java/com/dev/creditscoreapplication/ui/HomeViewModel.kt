package com.dev.creditscoreapplication.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.creditscoreapplication.source.Repository
import com.dev.creditscoreapplication.models.CreditScoreResponseBody
import com.dev.creditscoreapplication.models.ErrorStatus
import com.dev.creditscoreapplication.models.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject

/**
 * Copyright (c) 2021 Eniola Ipoola
 * All rights reserved
 * Created on 09-Nov-2021
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository): ViewModel() {

    val creditScoreState = MutableLiveData<Result<CreditScoreResponseBody>>()

    fun fetchCreditScoreData(){
        viewModelScope.launch(exceptionHandler(creditScoreState)){
            creditScoreState.postValue(Result.Loading(true))
            val result = repository.fetchCreditScoreData()
            creditScoreState.postValue(Result.Success(result))
        }
    }


    private fun <T> exceptionHandler(liveData: MutableLiveData<Result<T>>): CoroutineExceptionHandler {
        return CoroutineExceptionHandler{ _ , throwable ->
            var message = throwable.message.toString()
            when (throwable) {
                is IOException -> {
                    message = ErrorStatus.NO_CONNECTION
                }
                is UnknownHostException -> {

                }
                is SocketTimeoutException -> {
                    message = ErrorStatus.TIMEOUT
                }
                is HttpException -> {
                    message = ErrorStatus.UNAUTHORIZED
                }
            }
            liveData.postValue(Result.Error(message))
        }
    }
}