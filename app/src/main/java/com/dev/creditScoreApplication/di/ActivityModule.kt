package com.dev.creditScoreApplication.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent


@Module
@InstallIn(ActivityComponent::class)
interface ActivityModule {

    //@Binds
    //fun provideNavigationHelper(impl: NavigationHelperImpl): NavigationHelper
}