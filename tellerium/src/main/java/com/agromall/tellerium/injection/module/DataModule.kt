package com.agromall.tellerium.injection.module

import com.agromall.data.JobExecutor
import com.agromall.data.implementation.UserDataRepository
import com.agromall.domain.executor.ThreadExecutor
import com.agromall.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent

/**
 * Module used to provide dependencies at data level.
 */
@Module
@InstallIn(ApplicationComponent::class)
abstract class DataModule {
    @Binds
    abstract fun bindThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor

    @Binds
    abstract fun bindUserRepository(userRepository: UserDataRepository): UserRepository
}