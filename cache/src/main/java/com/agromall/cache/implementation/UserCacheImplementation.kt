package com.agromall.cache.implementation

import com.agromall.cache.mapper.user.UserEntityMapper
import com.agromall.data.repository.user.UsersCache
import com.agromall.domain.model.user.User
import io.altalabs.cache.db.AgromallDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapLatest
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
    override suspend fun saveUser(param: User) {
        return db.cachedUserDao().save(cacheUserMapper.mapToCached(param))
    }

    override fun getLoggedInUser(): Flow<User> {
        return db.cachedUserDao().getUser()
            .mapLatest { cacheUserMapper.mapFromCached(it) }
    }

    override suspend fun deleteUser(param: User) {
        return db.cachedUserDao().clear()
    }
}