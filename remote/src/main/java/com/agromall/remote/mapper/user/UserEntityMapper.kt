package com.agromall.remote.mapper.user

import com.agromall.domain.model.farmer.Farmer
import com.agromall.domain.model.user.User
import com.agromall.remote.mapper.EntityMapper
import com.agromall.remote.model.user.UserModel
import javax.inject.Inject

/**
 * Map a [UserModel] to and from a [User] instance when data is moving between
 * this later and the Data layer
 */
open class UserEntityMapper @Inject constructor() :
    EntityMapper<UserModel, User> {

    /**
     * Map an instance of a [UserModel] to a [Farmer] model
     */
    override fun mapFromRemote(type: UserModel): User {
        return User(
            type.name,
            type.email
        )
    }
}