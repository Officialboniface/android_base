package com.agromall.remote.mapper

import com.agromall.domain.model.user.Farmer
import com.agromall.remote.model.UserModel
import javax.inject.Inject

/**
 * Map a [UserModel] to and from a [Farmer] instance when data is moving between
 * this later and the Data layer
 */
open class UserEntityMapper @Inject constructor() :
    EntityMapper<UserModel, Farmer> {

    /**
     * Map an instance of a [UserModel] to a [Farmer] model
     */
    override fun mapFromRemote(type: UserModel): Farmer {
        return Farmer(type.name, type.email, type.id)
    }
}