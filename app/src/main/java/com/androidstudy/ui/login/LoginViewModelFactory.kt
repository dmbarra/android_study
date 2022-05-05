package com.androidstudy.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.androidstudy.data.LoginRepository
import com.androidstudy.network.LoginNetwork
import com.androidstudy.network.apiClientLogin

class LoginViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(
                loginRepository = LoginRepository(
                    loginNetwork = LoginNetwork(apiClientLogin())
                )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}