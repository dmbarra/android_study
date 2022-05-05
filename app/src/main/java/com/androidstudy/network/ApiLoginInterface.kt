package com.androidstudy.network

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiLoginInterface {

    @POST("login")
    fun login(@Body requestBody: RequestBody) : Call<ResponseBody>

    @POST("logout")
    fun logout(@Body requestBody: RequestBody) : Call<ResponseBody>

}