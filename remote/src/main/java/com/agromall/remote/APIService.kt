package com.agromall.remote

import com.agromall.domain.interactor.user.LoginUser
import com.agromall.remote.model.user.UserModel
import com.agromall.remote.util.NetworkResponse
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Defines the abstract methods used for interacting with the Agromall API
 */
interface APIService {

    //Users endpoints
    @POST("login")
    suspend fun loginUser(@Body params: LoginUser.Params): GenericResponse<UserModel>

    //Farmers endpoints

    //Farm endpoints

    //Aggregation endpoints

    //LandInput Management endpoints

    //Extension service endpoints

    //Input distribution endpoints

}

//Beautiful generic error mapping
typealias GenericResponse<S> = NetworkResponse<S, Error>

@JsonClass(generateAdapter = true)
data class Error(
    @Json(name = "status")
    val status: String,

    @Json(name = "message")
    val message: String
)