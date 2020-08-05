package com.agromall.tellerium.injection.module

import com.agromall.data.repository.user.UserRemote
import com.agromall.remote.APIService
import com.agromall.remote.APIServiceFactory
import com.agromall.remote.implementation.user.UserRemoteImplementation
import com.agromall.tellerium.BuildConfig
import dagger.Binds
import dagger.Module
import dagger.Provides

/**
 * Module that provides all dependencies from the remote layer.
 */
@Module
abstract  class RemoteModule {
    @Binds
    abstract fun bindUserRemote(userRemoteImpl: UserRemoteImplementation): UserRemote

    @Module
    companion object {
        /**
         * This companion object annotated as a module is necessary in order to provide dependencies
         * statically in case the wrapping module is an abstract class (to use binding)
         */

        /**
         * set user token to the api service
         */
        @Provides
        @JvmStatic
        fun provideRemoteApiService(): APIService {
            return APIServiceFactory.makeRemoteService(BuildConfig.DEBUG)
        }
    }
}