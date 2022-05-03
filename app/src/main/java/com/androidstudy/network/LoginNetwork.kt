package com.androidstudy.network

import androidx.core.view.accessibility.AccessibilityEventCompat
import androidx.lifecycle.MutableLiveData
import com.androidstudy.data.Result
import com.androidstudy.data.model.LoggedInUser
import com.androidstudy.data.model.LoginRequest
import com.google.gson.Gson
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import java.io.IOException

class LoginNetwork(private val apiService: ApiService) {

    fun login(loginRequest: LoginRequest): MutableLiveData<Result<LoggedInUser>> {
        val resultOfRequest : MutableLiveData<Result<LoggedInUser>> = MutableLiveData()
        val requestBody = Gson()
            .toJson(loginRequest)
            .toRequestBody("application/json".toMediaType())

       apiService.login(requestBody).enqueue(object : retrofit2.Callback<ResponseBody> {
           override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
               if(!response.isSuccessful){
                   resultOfRequest.value =  Result.Error(IOException("Error logging in"))
               }
               val responseMessage = response.body()?.string()
               val userFromResponse = Gson().fromJson(responseMessage, LoggedInUser::class.java)
               resultOfRequest.value = Result.Success(userFromResponse)
           }

           override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
               resultOfRequest.value = Result.Error(IOException("Error logging in"))
           }

       })
        return resultOfRequest
    }

    fun logout() {
        TODO("Not yet implemented")
    }
}

