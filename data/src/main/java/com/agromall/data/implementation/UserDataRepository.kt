package com.agromall.data.implementation

import com.agromall.data.source.user.UserDataStoreFactory
import com.agromall.domain.interactor.user.users.LoginUser
import com.agromall.domain.repository.UserRepository
import io.reactivex.Completable
import javax.inject.Inject

class UserDataRepository @Inject constructor(
    private val factory: UserDataStoreFactory
): UserRepository {
    override fun loginUser(param: LoginUser.Params): Completable {
        return factory.retrieveRemoteDataStore().loginUser(param)
    }
}