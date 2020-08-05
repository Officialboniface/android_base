package com.agromall.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.agromall.cache.model.CachedUserEntity
import io.altalabs.cache.db.constants.DBConstants
import io.reactivex.Single

/**
 * Provides data access methods for [User]
 */
@Dao
abstract class UserEntityDao {
    @Query("SELECT * FROM ${DBConstants.User.TABLE_NAME}")
    abstract fun getUser(): Single<CachedUserEntity>

    @Insert
    abstract fun save(user: CachedUserEntity)

    @Query("DELETE FROM ${DBConstants.User.TABLE_NAME}")
    abstract fun clear()

}