package com.agromall.data.repository.user

import com.agromall.domain.model.user.User
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Interface defining methods for the caching of [Farm]. This is to be implemented by the
 * cache layer, using this interface as a way of communicating.
 */
interface UsersCache {
    /**
     * Savings a user
     */
    fun saveUser(param: User): Completable

    /**
     * Retrieve a logged in user from the cache.
     */
    fun getLoggedInUser(): Single<User>

    /**
     * Retrieve a user by param from the cache.
     */
    fun getUserByParam(param: String): Single<User>

    /**
     * Save a given User by param to the cache.
     */
    fun saveUserByParam(param: String): Completable

    /**
     * Check whether there is a logged in user stored in the cache.
     *
     * @return true if the logged in user  is cached, otherwise false
     */
    fun isUserLoggedIn(): Boolean

    /**
     * Set a state of the logged in user
     */
    fun setUserIsLoggedIn(loggedIn: Boolean)

    /**
     * Check if the user specified by param is cached
     */
    fun isUserByParamCached(param: String): Single<Boolean>

    /**
     * Clear all Users from the cache.
     */
    fun clearUser(): Completable

    /**
     * update user
     */
    fun updateUser(param: User): Completable
}