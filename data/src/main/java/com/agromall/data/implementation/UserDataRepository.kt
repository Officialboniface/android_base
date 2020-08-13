package com.agromall.data.implementation

import com.agromall.data.source.user.UserDataStoreFactory
import com.agromall.domain.interactor.farmer.GetFarmers
import com.agromall.domain.interactor.user.LoginUser
import com.agromall.domain.model.farmer.Farmer
import com.agromall.domain.model.user.User
import com.agromall.domain.repository.UserRepository
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class UserDataRepository @Inject constructor(
    private val factory: UserDataStoreFactory
): UserRepository {
    override fun loginUser(param: LoginUser.Params): Flow<User> {
        return factory.retrieveRemoteDataStore().loginUser(param)
            .flatMapConcat {user ->
                factory.retrieveCacheDataStore().saveUser(user)
                flowOf(user)
            }
    }

    override fun getLoggedInUser(): Flow<User> {
        return factory.retrieveCacheDataStore().getLoggedInUser()
    }

    override fun getFarmers(param: GetFarmers.Params): Flow<List<Farmer>> {
        TODO("Not yet implemented")
    }
}