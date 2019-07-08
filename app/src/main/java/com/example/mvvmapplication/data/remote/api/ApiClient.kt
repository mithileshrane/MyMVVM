package com.example.mvvmapplication.data.remote.api


import com.example.mvvmapplication.ui.employeelist.GetEmployeeListIDRequestModel
import com.example.mvvmapplication.data.constant.APIConstants
import io.reactivex.Single


import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST


interface ApiClient {


    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST(APIConstants.RELATIVE_URL)
    fun getEmployeeListByID(@Body requestmodel: GetEmployeeListIDRequestModel): Single<String>


}