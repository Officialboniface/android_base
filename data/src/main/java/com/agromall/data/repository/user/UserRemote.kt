package com.agromall.data.repository.user

import com.agromall.domain.interactor.user.LoginUser
import io.reactivex.Completable

interface UserRemote {
    /**
     * Login a user
     */
    fun loginUser(param: LoginUser.Params): Completable
}