package io.altalabs.cache.db

import androidx.annotation.NonNull
import androidx.annotation.VisibleForTesting
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.agromall.cache.dao.UserEntityDao
import com.agromall.cache.model.CachedUserEntity
import javax.inject.Inject


/**
 * Provides the database instance
 */
@Database(
    entities = arrayOf(CachedUserEntity::class),
    exportSchema = false,
    version = 1
)
abstract class AgromallDatabase @Inject constructor() : RoomDatabase() {

    abstract fun cachedUserDao(): UserEntityDao

    companion object {
        private var INSTANCE: AgromallDatabase? = null

        /**
         * Migrate from:
         * version 1 - using the SQLiteDatabase API
         * to
         * version 2 - using Room
         */
        @VisibleForTesting
        val MIGRATION_1_2: Migration =
            object : Migration(1, 2) {
                override fun migrate(@NonNull database: SupportSQLiteDatabase) {

                }
            }

        private val sLock = Any()

    }
}