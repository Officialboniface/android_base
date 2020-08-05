package com.agromall.domain.repository

import com.agromall.domain.interactor.user.LoginUser
import io.reactivex.Completable

/**
 * Interface defining methods for how the data layer can pass data to and from the Domain layer.
 * This is to be implemented by the data layer, setting the requirements for the
 * operations that need to be implemented
 */
interface UserRepository {
    /**
     * Login a user
     */
    fun loginUser(param: LoginUser.Params): Completable
}