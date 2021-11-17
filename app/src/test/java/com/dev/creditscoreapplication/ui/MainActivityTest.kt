/*
package com.dev.creditscoreapplication.ui

import android.os.Looper.getMainLooper
import androidx.test.ext.junit.rules.ActivityScenarioRule
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.Config
import org.robolectric.annotation.LooperMode

*/
/**
 * Copyright (c) 2021 Eniola Ipoola
 * All rights reserved
 * Created on 17-Nov-2021
 *//*

@HiltAndroidTest
@Config(application = HiltTestApplication::class)
@RunWith(RobolectricTestRunner::class)
@LooperMode(LooperMode.Mode.PAUSED)   //run robolectric tests on the main thread
class MainActivityTest {

    @get:Rule(order = 0)
    var hiltAndroidRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    var activityScenarioRule  = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp(){
        hiltAndroidRule.inject()
    }

    @Test
    fun whenActivityIsLaunched_invokeNavigationHelperForFragment(){
        shadowOf(getMainLooper()).idle()
        activityScenarioRule.scenario  //allows launching of the activity
    }

}*/
