package com.dev.creditScoreApplication.ui.home

import com.dev.creditScoreApplication.datasource.RepositoryTest
import junit.framework.TestCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Test

/**
 * Copyright (c) 2021 Eniola Ipoola
 * All rights reserved
 * Created on 22-Nov-2021
 */
@ExperimentalCoroutinesApi
class HomeViewModelTest : TestCase() {

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

        //Then the result of the fetched method is observed method
        val value = homeViewModel.creditScoreState.value



        //assertThat(value. not(nullValue()))
    }

    @Test
    fun testGetCreditScoreState() {
        val value = homeViewModel.creditScoreState.value
    }

    fun testGetCreditScoreData() {

    }

    fun testFetchRemoteCreditScoreData() {

    }
}