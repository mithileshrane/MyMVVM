package com.example.mvvmapplication

import android.app.Application
import com.example.mvvmapplication.di.apiModule
import com.example.mvvmapplication.di.networkModule
import com.example.mvvmapplication.di.roomModule
import com.example.mvvmapplication.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MVVMApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin { modules(listOf(
            networkModule,
            apiModule,
            roomModule,
            viewModelModule
        )).androidContext(this@MVVMApp) }
    }
}
