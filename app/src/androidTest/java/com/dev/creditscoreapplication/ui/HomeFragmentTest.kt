/*
package com.dev.creditscoreapplication.ui

import androidx.fragment.app.testing.launchFragment
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.dev.creditscoreapplication.FakeAndroidTestRepository
import com.dev.creditscoreapplication.R
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

*/
/**
 * Copyright (c) 2021 Eniola Ipoola
 * All rights reserved
 * Created on 13-Nov-2021
 *//*

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
@MediumTest
@ExperimentalCoroutinesApi
class HomeFragmentTest  {

    private lateinit var repository: FakeAndroidTestRepository

    @Before
    fun initRepository() {
        repository = FakeAndroidTestRepository()
    }

    @Test
    fun clickDonutView_navigateToDetailPage()  {
        //given the home page
        repository.creditScoreSampleData

        val scenario = launchFragment<HomeFragment>(
            initialState = Lifecycle.State.INITIALIZED
        )
        scenario.moveToState(Lifecycle.State.CREATED)
        val navController = mock(NavController::class.java)
        scenario.onFragment {
            it.view?.let { it1 -> Navigation.setViewNavController(it1, navController) }
        }
        //onclick of donut view
        onView(withId(R.id.credit_score_donut_view)).perform(
            ViewActions.click()
        )
        //navigate to detail page
        verify(navController).navigate(HomeFragmentDirections.actionHomeToDetail())

    }
}
*/
