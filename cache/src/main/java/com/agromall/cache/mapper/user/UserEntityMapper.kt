package com.agromall.cache.mapper.user

import com.agromall.cache.mapper.EntityMapper
import com.agromall.cache.model.user.CachedUserEntity
import com.agromall.domain.model.farmer.Farmer
import com.agromall.domain.model.user.User
import javax.inject.Inject

/**
 * Map a [CachedUserEntity] instance to and from a [Farmer] instance when data is moving between
 * this later and the Data layer
 */
open class UserEntityMapper @Inject constructor() :
    EntityMapper<CachedUserEntity, User> {

    /**
     * Map a [User] instance to a [CachedUser] instance
     */
    override fun mapToCached(type: User): CachedUserEntity {
        return CachedUserEntity(
            type.name,
            type.email,
            0
        )
    }

    /**
     * Map a [CachedUser] instance to a [User] instance
     */
    override fun mapFromCached(type: CachedUserEntity): User {
        return User(type.name, type.email)
    }
}