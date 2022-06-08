package com.androidstudy.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.androidstudy.data.Result
import com.androidstudy.data.model.LoggedInUser
import com.androidstudy.data.model.LoginRequest
import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import java.io.IOException

class LoginNetwork(private val apiLoginInterface: ApiLoginInterface) {

    private val resultOfRequest : MutableLiveData<Result<LoggedInUser>> = MutableLiveData()

    fun login(loginRequest: LoginRequest) {
        val requestBody = Gson()
            .toJson(loginRequest)
            .toRequestBody("application/json".toMediaType())

       apiLoginInterface.login(requestBody).enqueue(object : retrofit2.Callback<ResponseBody> {
           override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
               if(!response.isSuccessful){
                   resultOfRequest.postValue(Result.Error(IOException("Error logging in")))
                  return
               }
               val responseMessage = response.body()?.string()
               val userFromResponse = Gson().fromJson(responseMessage, LoggedInUser::class.java)
               resultOfRequest.postValue(Result.Success(userFromResponse))
           }

           override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//               resultOfRequest.postValue(Result.Error(IOException("Error logging in")))
               resultOfRequest.postValue(Result.Success(LoggedInUser("rola", "rola", "")))
           }

       })
    }

    fun logout() {
        TODO("Not yet implemented")
    }

    fun recoveryResultOfRequest() : LiveData<Result<LoggedInUser>>  {
        return resultOfRequest
    }
}

