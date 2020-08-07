package com.agromall.data.repository.user

import com.agromall.domain.interactor.user.users.LoginUser
import com.agromall.domain.model.user.Farmer
import io.reactivex.Completable

/**
 * Interface defining methods for the data operations related to [Farmer].
 * This is to be implemented by external data source layers, setting the requirements for the
 * operations that need to be implemented
 */
interface UserDataStore {
    /**
     * Login a user
     */
    fun loginUser(param: LoginUser.Params): Completable

    /**
     * Savings a farm
     */
    fun saveUser(param: Farmer): Completable
}