package com.dev.creditscoreapplication.models

/**
 * Copyright (c) 2021 Eniola Ipoola
 * All rights reserved
 * Created on 09-Nov-2021
 */
sealed class ResultWrapper<out T> {
    data class Success<out T>(val value: T) : ResultWrapper<T>()
    data class Loading(val loading: Boolean) : ResultWrapper<Boolean>()
    data class Error(val error: String) : ResultWrapper<Nothing>()
}