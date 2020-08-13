package com.agromall.remote.model.user

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserModel(
    @Json(name = "name") val name: String,
    @Json(name = "email")val email: String,
    @Json(name = "id")val id: Int
)