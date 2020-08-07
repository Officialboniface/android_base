package com.agromall.data.source.user

import com.agromall.data.repository.user.UserDataStore
import com.agromall.data.repository.user.UserRemote
import com.agromall.domain.interactor.user.users.LoginUser
import com.agromall.domain.model.user.Farmer
import io.reactivex.Completable
import javax.inject.Inject

/**
 * Implementation of the [UserDataStore] interface to provide a means of communicating
 * with the local data source
 */
class UserRemoteDataSource @Inject constructor(
    private val userRemote: UserRemote): UserDataStore {
    override fun loginUser(param: LoginUser.Params): Completable {
        return userRemote.loginUser(param)
    }

    override fun saveUser(param: Farmer): Completable {
        throw UnsupportedOperationException("Operation not supported here.")
    }
}