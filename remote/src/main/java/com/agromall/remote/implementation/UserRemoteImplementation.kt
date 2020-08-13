package com.agromall.remote.implementation

import com.agromall.data.repository.user.UserRemote
import com.agromall.domain.interactor.user.LoginUser
import com.agromall.domain.model.user.User
import com.agromall.remote.APIService
import com.agromall.remote.mapper.user.UserEntityMapper
import com.agromall.remote.util.NetworkResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class UserRemoteImplementation @Inject constructor(
    private val apiService: APIService,
    private val userEntityMapper: UserEntityMapper
) : UserRemote {

    override fun loginUser(param: LoginUser.Params): Flow<User> {
        return flow {
            val response = apiService.loginUser(param)
            when (response) {
                is NetworkResponse.Success -> emit(userEntityMapper.mapFromRemote(response.body)) // request succeded
                is NetworkResponse.ApiError -> emit(throw Throwable(response.body.message)) // request failed
                is NetworkResponse.NetworkError -> emit(throw Throwable(response.error.localizedMessage))// network error
                is NetworkResponse.UnknownError -> emit(throw Throwable( response.error?.localizedMessage))// unknown error happened
            }
        }
    }
}