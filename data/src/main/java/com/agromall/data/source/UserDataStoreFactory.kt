package com.agromall.data.source

import com.agromall.data.repository.user.UserDataStore
import javax.inject.Inject

/**
 * Factory to create an instance of a [UserDataStore]
 */
class UserDataStoreFactory @Inject constructor(
    private val userCacheDataSource: UserCacheDataSource,
    private val userRemoteDataSource: UserRemoteDataSource
) {

    /**
     * Return an instance of the [UserDataStore]
     */
    fun retrieveCacheDataStore(): UserDataStore {
        return userCacheDataSource
    }

    /**
     * Return an instance of the [UserDataStore]
     */
    fun retrieveRemoteDataStore(): UserDataStore {
        return userRemoteDataSource
    }
}