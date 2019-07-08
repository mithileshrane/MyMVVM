package com.example.mvvmapplication.di

import com.example.mvvmapplication.data.db.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * @author Leopold
 */
val roomModule = module {
    single { AppDatabase.getInstance(androidContext()) }
    single(createdAtStart = false){
        get<AppDatabase>().getEmployeeDao()
    }
}