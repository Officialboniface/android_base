package io.altalabs.cache.db.constants

/**
 * Defines constants for the Agromall Table
 */
object DBConstants {

    object User {
        const val TABLE_NAME = "users"

        const val QUERY_USERS = "SELECT * FROM" + " " + TABLE_NAME

        const val DELETE_ALL_USERS = "DELETE FROM" + " " + TABLE_NAME
    }
}