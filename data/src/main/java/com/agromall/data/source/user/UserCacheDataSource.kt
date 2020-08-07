package com.agromall.data.source.user

import com.agromall.data.repository.user.UserDataStore
import com.agromall.data.repository.user.UsersCache
import com.agromall.domain.interactor.user.users.LoginUser
import com.agromall.domain.model.user.Farmer
import io.reactivex.Completable
import javax.inject.Inject

/**
 * Implementation of the [UserDataStore] interface to provide a means of communicating
 * with the local data source
 */
class UserCacheDataSource @Inject constructor(
    private val userCache: UsersCache): UserDataStore {
    override fun loginUser(param: LoginUser.Params): Completable {
        throw UnsupportedOperationException("Operation not supported in this layer")
    }

    override fun saveUser(param: Farmer): Completable {
        return userCache.saveUser(param)
    }
}