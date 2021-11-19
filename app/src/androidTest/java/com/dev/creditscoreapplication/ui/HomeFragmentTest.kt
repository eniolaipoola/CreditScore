package com.dev.creditscoreapplication.ui

import androidx.test.espresso.Espresso.onView
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.dev.creditscoreapplication.FakeAndroidTestRepository
import com.dev.creditscoreapplication.R
import com.dev.creditscoreapplication.customView.DonutView
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.Matchers.*
import org.junit.runner.RunWith

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
        }
    }

    @Test
    fun testSetDonutViewText_SomeValue_DonutViewHasValue(){
        onView(allOf(withId(R.id.credit_score_donut_view), isDisplayed()))
    }

    /*@Test
    fun clickDonutView_navigateToDetailPage()  {
        //given the home page
        launchFragmentInHiltContainer<HomeFragment>(themeResId = R.style.ThemeOverlay_AppCompat_Dark)
        val navController = mock(NavController::class.java)
        //onclick of donut view
        onView(
            allOf(withId(R.id.credit_score_donut_view))
        ).perform(ViewActions.click())
        //navigate to detail page
        verify(navController).navigate(HomeFragmentDirections.actionHomeToDetail())

    }*/
}
