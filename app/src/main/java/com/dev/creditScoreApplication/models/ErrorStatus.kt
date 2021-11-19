package com.dev.creditScoreApplication.models

class ErrorStatus {

    companion object {
        const val NO_CONNECTION = "Not Connected To Internet"
        const val UNAUTHORIZED = "Something went wrong"
        const val TIMEOUT = "Request has been Timed out, please retry"
    }
}