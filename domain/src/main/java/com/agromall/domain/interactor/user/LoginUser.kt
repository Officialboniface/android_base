package com.agromall.domain.interactor.user

import com.agromall.domain.executor.PostExecutionThread
import com.agromall.domain.executor.ThreadExecutor
import com.agromall.domain.repository.UserRepository
import com.agromall.domain.usecase.CompletableUseCase
import io.reactivex.Completable
import javax.inject.Inject

/**
 * Use case for log in user
 */
class LoginUser @Inject constructor(
    val repository: UserRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) : CompletableUseCase<LoginUser.Params>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(params: LoginUser.Params): Completable {
        return repository.loginUser(params)
    }
    data class Params(
        val email: String,
        val password: String
    )
}