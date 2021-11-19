package com.dev.creditScoreApplication.utils

import androidx.lifecycle.MutableLiveData
import com.dev.creditScoreApplication.models.ErrorStatus
import com.dev.creditScoreApplication.models.Result
import kotlinx.coroutines.CoroutineExceptionHandler
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

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
