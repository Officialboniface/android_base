package com.agromall.cache.implementation

import com.agromall.cache.mapper.UserEntityMapper
import com.agromall.data.repository.user.UsersCache
import com.agromall.domain.model.user.User
import io.altalabs.cache.db.AgromallDatabase
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

/**
 * Cached implementation for retrieving and saving User instances. This class implements the
 * [UserCache] from the Data layer as it is that layers responsibility for defining the
 * operations in which data store implementation layers can carry out.
 */
class UserCacheImplementation  @Inject constructor(
    val db: AgromallDatabase,
    private val cacheUserMapper: UserEntityMapper
) : UsersCache {

    override fun saveUser(param: User): Completable {
        return Completable.fromAction {
            db.cachedUserDao().save(cacheUserMapper.mapToCached(param))
        }
    }

    override fun getLoggedInUser(): Single<User> {
        TODO("Not yet implemented")
    }

    override fun getUserByParam(param: String): Single<User> {
        TODO("Not yet implemented")
    }

    override fun saveUserByParam(param: String): Completable {
        TODO("Not yet implemented")
    }

    override fun isUserLoggedIn(): Boolean {
        TODO("Not yet implemented")
    }

    override fun setUserIsLoggedIn(loggedIn: Boolean) {
        TODO("Not yet implemented")
    }

    override fun isUserByParamCached(param: String): Single<Boolean> {
        TODO("Not yet implemented")
    }

    override fun clearUser(): Completable {
        TODO("Not yet implemented")
    }

    override fun updateUser(param: User): Completable {
        TODO("Not yet implemented")
    }
}