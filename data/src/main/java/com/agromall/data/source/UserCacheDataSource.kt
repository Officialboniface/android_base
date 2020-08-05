package com.agromall.data.source

import com.agromall.data.repository.user.UserDataStore
import com.agromall.data.repository.user.UsersCache
import com.agromall.domain.interactor.user.LoginUser
import com.agromall.domain.model.user.User
import io.reactivex.Completable
import javax.inject.Inject

/**
 * Implementation of the [UserDataStore] interface to provide a means of communicating
 * with the local data source
 */
class UserCacheDataSource @Inject constructor(
    private val userCache: UsersCache): UserDataStore {
    override fun loginUser(param: LoginUser.Params): Completable {
        TODO("Not yet implemented")
    }

    override fun saveUser(param: User): Completable {
        TODO("Not yet implemented")
    }
}