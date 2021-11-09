package com.dev.creditscoreapplication.datasource

import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

/**
 * Copyright (c) 2021 Eniola Ipoola
 * All rights reserved
 * Created on 06-Nov-2021
 */
class Repository @Inject constructor(
    private val dispatcher: CoroutineDispatcher){
}