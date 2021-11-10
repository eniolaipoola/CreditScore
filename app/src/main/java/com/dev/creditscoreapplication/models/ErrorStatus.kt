package com.dev.creditscoreapplication.models

/**
 * Copyright (c) 2021 Eniola Ipoola
 * All rights reserved
 * Created on 10-Nov-2021
 */
class ErrorStatus {

    companion object {
        const val NO_CONNECTION = "Not Connected To Internet"
        const val UNAUTHORIZED = "Something went wrong"
        const val TIMEOUT = "Request has been Timed out, please retry"
    }
}