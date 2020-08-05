package com.agromall.remote.mapper

import com.agromall.domain.model.user.User
import com.agromall.remote.model.UserModel
import javax.inject.Inject

/**
 * Map a [UserModel] to and from a [User] instance when data is moving between
 * this later and the Data layer
 */
open class UserEntityMapper @Inject constructor() :
    EntityMapper<UserModel, User> {

    /**
     * Map an instance of a [UserModel] to a [User] model
     */
    override fun mapFromRemote(type: UserModel): User {
        return User(type.name, type.email, type.id)
    }
}