package com.dev.creditscoreapplication.models

/**
 * Copyright (c) 2021 Eniola Ipoola
 * All rights reserved
 * Created on 09-Nov-2021
 */
sealed class Result<out T> {
    data class Success<out T>(val value: T) : Result<T>()
    data class Loading(val loading: Boolean) : Result<Nothing>()
    data class Error(val error: String) : Result<Nothing>()
}