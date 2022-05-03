package com.androidstudy.data

import androidx.lifecycle.MutableLiveData
import com.androidstudy.data.model.LoggedInUser
import com.androidstudy.data.model.LoginRequest
import com.androidstudy.network.LoginNetwork

class LoginRepository(val loginNetwork: LoginNetwork) {

    var user: LoggedInUser? = null
        private set

    val isLoggedIn: Boolean
        get() = user != null

    init {
        user = null
    }

    fun logout() {
        user = null
        loginNetwork.logout()
    }

    fun login(loginRequest: LoginRequest): MutableLiveData<Result<LoggedInUser>> {
        return loginNetwork.login(loginRequest)
    }

    private fun setLoggedInUser(loggedInUser: LoggedInUser) {
        this.user = loggedInUser
    }
}