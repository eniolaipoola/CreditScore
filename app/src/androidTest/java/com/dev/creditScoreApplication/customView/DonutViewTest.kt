package com.dev.creditScoreApplication.customView

import android.view.LayoutInflater
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Copyright (c) 2021 Eniola Ipoola
 * All rights reserved
 * Created on 13-Nov-2021
 */

@RunWith(AndroidJUnit4::class)
class DonutViewTest {

    lateinit var donutView: DonutView

    @Before
    fun setUp() {
       val view = LayoutInflater.from(ApplicationProvider.getApplicationContext())
            .inflate(R.layout.fragment_home, null)
        donutView = view.findViewById(R.id.credit_score_donut_view)
    }

    @Test
    fun testSetDonutViewText_SomeValue_DonutViewHasValue(){
        launchFragmentInHiltContainer<HomeFragment>()
        donutView.setText("Hello Eniola")
        onView(allOf(withId(R.id.credit_score_donut_view), isDisplayed()))
    }
}
