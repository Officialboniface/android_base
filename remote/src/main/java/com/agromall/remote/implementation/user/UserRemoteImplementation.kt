package com.agromall.remote.implementation.user

import com.agromall.data.repository.user.UserRemote
import com.agromall.domain.interactor.user.LoginUser
import com.agromall.domain.model.user.User
import com.agromall.remote.APIService
import com.agromall.remote.mapper.UserEntityMapper
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject

class UserRemoteImplementation @Inject constructor(
    private val apiService: APIService,
    private val userEntityMapper: UserEntityMapper
) : UserRemote {

    override fun loginUser(param: LoginUser.Params): Completable {
        return apiService.login(param).ignoreElement()
            .onErrorResumeNext { completableErrorHandler(it) }
    }
}


val completableErrorHandler: (Throwable) -> Completable = { error ->
    when (error) {
        is UnknownHostException -> Completable.error(Throwable("No Internet connection available."))
        is SocketTimeoutException -> Completable.error(Throwable("Internet connection failed, check and try again"))
        else -> Completable.error(error)
    }
}

fun <T> singleErrorHandler(error: Throwable): Single<T> {
    return when (error) {
        is UnknownHostException -> Single.error<T>(Throwable("No Internet connection available."))
        is SocketTimeoutException -> Single.error<T>(Throwable("Internet connection failed, check and try again"))
        else -> Single.error(error)
    }
}

fun <T> observableErrorHandler(error: Throwable): Observable<T> {
    return when (error) {
        is UnknownHostException -> Observable.error<T>(Throwable("No Internet connection available."))
        is SocketTimeoutException -> Observable.error<T>(Throwable("Internet connection failed, check and try again"))
        else -> Observable.error(error)
    }
}