package com.dev.creditScoreApplication.models

sealed class Result<out T> {
    data class Success<out T>(val value: T) : Result<T>()
    data class Loading(val loading: Boolean) : Result<Nothing>()
    data class Error(val error: String) : Result<Nothing>()
}