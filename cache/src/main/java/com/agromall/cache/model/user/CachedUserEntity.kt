package com.agromall.cache.model.user

import androidx.room.Entity
import androidx.room.PrimaryKey
import io.altalabs.cache.db.constants.DBConstants

@Entity(tableName = DBConstants.User.TABLE_NAME)
data class CachedUserEntity (
    var name: String,
    var email: String,
    @PrimaryKey var id: Int
)