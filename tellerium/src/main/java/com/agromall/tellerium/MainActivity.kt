package com.agromall.tellerium

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.agromall.domain.interactor.user.users.LoginUser
import com.agromall.presentation.state.Resource
import com.agromall.presentation.state.ResourceState
import com.agromall.presentation.viewmodel.UsersViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    val usersViewModel: UsersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
    }

    /**
     * provide viewmodel instance for the class
     */
    private fun initViewModel() {
        usersViewModel.loginUserLiveData.observe(this, Observer {
            handleLoginUser(it)
        })
        usersViewModel.loginUser(LoginUser.Params("", ""))
    }

    /**
     * Handles the state of the login user
     */
    private fun handleLoginUser(resource: Resource<Unit>) {
        when (resource.status) {
            ResourceState.LOADING -> {

            }
            ResourceState.SUCCESS -> {

            }
            ResourceState.ERROR -> {

            }
        }
    }

}

