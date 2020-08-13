package com.agromall.data.source.user

import com.agromall.data.repository.user.UserDataStore
import com.agromall.data.repository.user.UserRemote
import com.agromall.domain.interactor.user.LoginUser
import com.agromall.domain.model.user.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Implementation of the [UserDataStore] interface to provide a means of communicating
 * with the local data source
 */
class UserRemoteDataSource @Inject constructor(
    private val userRemote: UserRemote): UserDataStore {
    override fun loginUser(param: LoginUser.Params): Flow<User> {
        return userRemote.loginUser(param)
    }

    override suspend fun saveUser(param: User) {
        throw UnsupportedOperationException("Operation not supported in this layer")
    }

    override fun getLoggedInUser(): Flow<User> {
        throw UnsupportedOperationException("Operation not supported in this layer")
    }

    override suspend fun deleteUser(param: User) {
        throw UnsupportedOperationException("Operation not supported in this layer")
    }
}