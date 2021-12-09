package com.dev.creditScoreApplication.ui

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.dev.creditScoreApplication.FakeAndroidTestRepository
import com.dev.creditScoreApplication.R
import com.dev.creditScoreApplication.customView.DonutView
import com.dev.creditScoreApplication.models.CreditScoreEntity
import com.dev.creditScoreApplication.ui.home.HomeFragment
import com.dev.creditScoreApplication.ui.home.HomeFragmentDirections
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.hamcrest.Matchers.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

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
    lateinit var creditScoreData: CreditScoreEntity

    @Before
    fun initRepository() {
        repository = FakeAndroidTestRepository()
        creditScoreData = repository.creditScoreSampleData
    }

    @Test
    fun drawDonut_DisplayCreditScoreInUI() {
        launchFragmentInHiltContainer<HomeFragment> {
            assert(this.view?.findViewById<DonutView>(R.id.credit_score_donut_view) != null)
            val score = creditScoreData.creditReportInfo.score
            val maxScore = creditScoreData.creditReportInfo.maxScoreValue
            assertThat(score, lessThan(maxScore))
        }
    }

    @Test
    fun testDonutView_isDisplayed(){
        onView(allOf(withId(R.id.credit_score_donut_view), isDisplayed()))
    }

    @Test
    fun clickDonutView_navigateToDetailPage()  {
        //Given, the home page
        val data = creditScoreData.creditReportInfo
        val bundleData = Bundle().apply {
            putParcelable("creditInfoData", data)
        }

        val navController = mock(NavController::class.java)
        launchFragmentInHiltContainer<HomeFragment>(bundleData,
            themeResId = R.style.ThemeOverlay_AppCompat_Dark){
            Navigation.setViewNavController( this.view!!, navController)
        }

        //When, onclick of donut view
       /* onView(
            allOf(withId(R.id.credit_score_donut_view), `is`(isClickable()))).perform(click())*/

        onView(
            allOf(withId(R.id.credit_score_donut_view), `is`(isDisplayed()))).perform(click())

        //Then, navigate to detail page
        verify(navController).navigate(HomeFragmentDirections.actionHomeToDetail())

    }
}
