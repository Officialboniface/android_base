package com.agromall.tellerium.injection.module

import com.agromall.domain.executor.PostExecutionThread
import com.agromall.tellerium.MainActivity
import com.agromall.tellerium.UiThread
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Module that provides all dependencies from the mobile-ui package/layer and injects all activities.
 */
@Module
abstract class UiModule {

    @Binds
    abstract fun bindPostExecutionThread(uiThread: UiThread): PostExecutionThread

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}