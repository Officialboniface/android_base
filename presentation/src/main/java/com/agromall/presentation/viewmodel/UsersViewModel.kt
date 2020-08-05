package com.agromall.presentation.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.agromall.domain.interactor.user.LoginUser
import com.agromall.presentation.state.Resource
import com.agromall.presentation.state.ResourceState
import io.reactivex.observers.DisposableCompletableObserver
import javax.inject.Inject

/**
 * [UsersViewModel] handle all interactions with the UI layer
 */
open class UsersViewModel @Inject constructor(
    private val loginUser: LoginUser
) : ViewModel() {
    //mutable livedata should be private to a single class
    private val _loginUserLiveData: MutableLiveData<Resource<Unit>> = MutableLiveData()

    //exposing MutableLivedata to corresponding Livedata objects
    val loginUserLiveData: LiveData<Resource<Unit>>
        get() = _loginUserLiveData

    override fun onCleared() {
//        getUser.dispose()
        super.onCleared()
    }

    /**
     * Login a user
     */
    fun loginUser(param: LoginUser.Params){
        _loginUserLiveData.postValue(Resource(ResourceState.LOADING, null, null))
        loginUser.execute(LoginUserCompletableSubscriber(), param)
    }

    inner class LoginUserCompletableSubscriber: DisposableCompletableObserver() {
        override fun onComplete() {
            _loginUserLiveData.postValue(Resource(ResourceState.SUCCESS, null, null))
        }

        override fun onError(e: Throwable) {
            _loginUserLiveData.postValue(Resource(ResourceState.ERROR, null, e.localizedMessage))
        }
    }
}