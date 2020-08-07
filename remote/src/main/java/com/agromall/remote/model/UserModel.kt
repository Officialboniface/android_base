package com.agromall.remote.model

import com.squareup.moshi.Json

data class UserModel(
    val name: String,
    val email: String,
    val id: Int
)