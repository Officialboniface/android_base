package com.agromall.tellerium

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.agromall.domain.interactor.user.LoginUser
import com.agromall.domain.model.user.User
import com.agromall.presentation.state.UIState
import com.agromall.presentation.viewmodel.UsersViewModel
import com.agromall.tellerium.util.showSnackbar
import dagger.hilt.android.AndroidEntryPoint

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
        usersViewModel.getLoggedInUserLiveData.observe(this, Observer {
            handleGetLoggedInUser(it)
        })
        usersViewModel.loginUser(LoginUser.Params("", ""))
//        usersViewModel.getLoggedInUser()
    }

    /**
     * Handles the state of the login user
     */
    private fun handleLoginUser(uiState: UIState<User>) {
        when (uiState) {
            is UIState.Success -> {
                showSnackbar(uiState.body.toString())
            }
            is UIState.Failed -> {
                showSnackbar(uiState.error.toString())
            }
            is UIState.Loading -> {

            }
        }
    }

    /**
     * Handles the state of the get logged in user
     */
    private fun handleGetLoggedInUser(uiState: UIState<User>) {
        when (uiState) {
            is UIState.Success -> {
                showSnackbar(uiState.body.toString())
            }
            is UIState.Failed -> {
                showSnackbar(uiState.error.toString())
            }
            is UIState.Loading -> {

            }
        }
    }
}

