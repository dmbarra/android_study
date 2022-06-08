package com.androidstudy.ui.login

import com.androidstudy.data.model.LoggedInUser

data class LoggedInUserView(
    val userId: String,
    val displayName: String,
    val accessToken: String
) {
    constructor(loggedInUser: LoggedInUser) : this(loggedInUser.userId, loggedInUser.displayName, loggedInUser.accessToken)
}
