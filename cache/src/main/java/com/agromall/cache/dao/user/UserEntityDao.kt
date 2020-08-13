package com.agromall.cache.dao.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.agromall.cache.model.user.CachedUserEntity
import io.altalabs.cache.db.constants.DBConstants
import kotlinx.coroutines.flow.Flow

/**
 * Provides data access methods for [User]
 */
@Dao
abstract class UserEntityDao {
    @Query("SELECT * FROM ${DBConstants.User.TABLE_NAME} LIMIT 1")
    abstract fun getUser(): Flow<CachedUserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun save(user: CachedUserEntity)

    @Query("DELETE FROM ${DBConstants.User.TABLE_NAME}")
    abstract suspend fun clear()
}