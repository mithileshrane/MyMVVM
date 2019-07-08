package com.example.mvvmapplication.di

import com.example.mvvmapplication.data.remote.api.ApiClient
import com.example.mvvmapplication.data.remote.api.RetrofitApi
import org.koin.dsl.module
import retrofit2.Retrofit


val apiModule=module{

   /* single (createdAtStart = false){
        get<RetrofitApi>().getClient()
    }*/
    single (createdAtStart = false){
        get<Retrofit>().create(ApiClient::class.java)
    }
}