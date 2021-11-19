package com.dev.creditscoreapplication.utils

import androidx.lifecycle.MutableLiveData
import com.dev.creditscoreapplication.models.ErrorStatus
import com.dev.creditscoreapplication.models.Result
import kotlinx.coroutines.CoroutineExceptionHandler
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * Copyright (c) 2021 Eniola Ipoola
 * All rights reserved
 * Created on 19-Nov-2021
 */
fun <T> exceptionHandler(liveData: MutableLiveData<Result<T>>): CoroutineExceptionHandler {
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
