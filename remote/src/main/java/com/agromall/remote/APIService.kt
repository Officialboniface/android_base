package com.agromall.remote

import com.agromall.domain.interactor.user.users.LoginUser
import com.agromall.remote.model.UserModel
import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Defines the abstract methods used for interacting with the Agromall API
 */
interface APIService {

    @GET("test.json")
    fun getUsers(): Flowable<List<UserModel>>

    @POST("login")
    fun login(@Body params: LoginUser.Params): Single<UserModel>

}