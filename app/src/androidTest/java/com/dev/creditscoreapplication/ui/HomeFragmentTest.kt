package com.dev.creditscoreapplication.ui

import androidx.navigation.NavController
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.dev.creditscoreapplication.FakeAndroidTestRepository
import com.dev.creditscoreapplication.R
import com.dev.creditscoreapplication.customView.DonutView
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.lessThan
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*

/**
 * Copyright (c) 2021 Eniola Ipoola
 * All rights reserved
 * Created on 13-Nov-2021
 */

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
    fun drawDonut_DisplayCreditScoreInUI() {
        val creditScoreData = repository.creditScoreSampleData
        launchFragmentInHiltContainer<HomeFragment> {
            assert(this.view?.findViewById<DonutView>(R.id.credit_score_donut_view) != null)

            val score = creditScoreData.creditReportInfo.score
            val maxScore = creditScoreData.creditReportInfo.maxScoreValue
            assertThat(score, lessThan(maxScore))
            this.view?.findViewById<DonutView>(R.id.credit_score_donut_view)?.performClick()
        }
    }

    @Test
    fun clickDonutView_navigateToDetailPage()  {
        //given the home page
        launchFragmentInHiltContainer<HomeFragment>(themeResId = R.style.ThemeOverlay_AppCompat_Dark)
        val navController = mock(NavController::class.java)

        //onclick of donut view
        onView(withId(R.id.credit_score_donut_view)).perform(
            ViewActions.click()
        )
        //navigate to detail page
        verify(navController).navigate(HomeFragmentDirections.actionHomeToDetail())

    }
}
