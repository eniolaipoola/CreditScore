package com.dev.creditscoreapplication.ui

import com.dev.creditscoreapplication.datasource.RepositoryTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Test

/**
 * Copyright (c) 2021 Eniola Ipoola
 * All rights reserved
 * Created on 13-Nov-2021
 * */
@ExperimentalCoroutinesApi
class HomeViewModelTest {

    private lateinit var creditScoreRepository: RepositoryTest
    private lateinit var homeViewModel: HomeViewModel

    @Before
    fun setupViewModel(){
        creditScoreRepository = RepositoryTest()
        creditScoreRepository.createRepository()
        homeViewModel = HomeViewModel(creditScoreRepository.repository)
    }

    @Test
    fun getCreditScoreDataFromDatabase_setSuccessResult() {
        //Fetch creditScoreData
        homeViewModel.fetchRemoteCreditScoreData()

        //Then call the Result.Success method
        val value = homeViewModel.creditScoreState.value
    }
}
