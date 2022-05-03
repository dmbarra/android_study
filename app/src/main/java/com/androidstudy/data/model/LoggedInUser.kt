package com.androidstudy.data.model


data class LoggedInUser(
    val userId: String,
    val displayName: String,
    val accessToken: String
)