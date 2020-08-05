package com.agromall.cache.mapper

import com.agromall.cache.model.CachedUserEntity
import com.agromall.domain.model.user.User
import javax.inject.Inject

/**
 * Map a [CachedUserEntity] instance to and from a [User] instance when data is moving between
 * this later and the Data layer
 */
open class UserEntityMapper @Inject constructor() :
    EntityMapper<CachedUserEntity, User> {

    /**
     * Map a [User] instance to a [CachedBufferoo] instance
     */
    override fun mapToCached(type: User): CachedUserEntity {
        return CachedUserEntity(type.name, type.email, type.id)
    }

    /**
     * Map a [CachedBufferoo] instance to a [User] instance
     */
    override fun mapFromCached(type: CachedUserEntity): User {
        return User(type.name, type.email, type.id)
    }
}