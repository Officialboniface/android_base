package com.agromall.cache.mapper

import com.agromall.cache.model.CachedUserEntity
import com.agromall.domain.model.user.Farmer
import javax.inject.Inject

/**
 * Map a [CachedUserEntity] instance to and from a [Farmer] instance when data is moving between
 * this later and the Data layer
 */
open class UserEntityMapper @Inject constructor() :
    EntityMapper<CachedUserEntity, Farmer> {

    /**
     * Map a [Farmer] instance to a [CachedBufferoo] instance
     */
    override fun mapToCached(type: Farmer): CachedUserEntity {
        return CachedUserEntity(type.name, type.email, type.id)
    }

    /**
     * Map a [CachedBufferoo] instance to a [Farmer] instance
     */
    override fun mapFromCached(type: CachedUserEntity): Farmer {
        return Farmer(type.name, type.email, type.id)
    }
}