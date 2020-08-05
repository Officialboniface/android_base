package com.agromall.tellerium.injection.module

import android.app.Application
import androidx.room.Room
import com.agromall.cache.implementation.UserCacheImplementation
import com.agromall.data.repository.user.UsersCache
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.altalabs.cache.db.AgromallDatabase

/**
 * Module that provides all dependencies from the cache layer.
 */
@Module
abstract class CacheModule {

    @Binds
    abstract fun bindUserCache(userCacheImpl: UserCacheImplementation): UsersCache

    @Module
    companion object {
        @Provides
        @JvmStatic
        fun provideAgromallDatabase(application: Application): AgromallDatabase {
            return Room.databaseBuilder(
                application.applicationContext,
                AgromallDatabase::class.java, "agromall.db"
            ).build()
        }
    }
}