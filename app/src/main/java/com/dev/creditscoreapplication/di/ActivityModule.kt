package com.dev.creditscoreapplication.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

/**
 * Copyright (c) 2021 Eniola Ipoola
 * All rights reserved
 * Created on 19-Nov-2021
 */
@Module
@InstallIn(ActivityComponent::class)
interface ActivityModule {

    //@Binds
    //fun provideNavigationHelper(impl: NavigationHelperImpl): NavigationHelper
}