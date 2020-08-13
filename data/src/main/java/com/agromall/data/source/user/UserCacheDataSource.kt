package com.agromall.data.source.user

import com.agromall.data.repository.user.UserDataStore
import com.agromall.data.repository.user.UsersCache
import com.agromall.domain.interactor.user.LoginUser
import com.agromall.domain.model.user.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Implementation of the [UserDataStore] interface to provide a means of communicating
 * with the local data source
 */
class UserCacheDataSource @Inject constructor(
    private val userCache: UsersCache): UserDataStore {
    override fun loginUser(param: LoginUser.Params): Flow<User> {
        throw UnsupportedOperationException("Operation not supported in this layer")
    }

    override suspend fun saveUser(param: User) {
        return userCache.saveUser(param)
    }

    override fun getLoggedInUser(): Flow<User> {
        return userCache.getLoggedInUser()
    }

    override suspend fun deleteUser(param: User) {
        return userCache.deleteUser(param)
    }
}