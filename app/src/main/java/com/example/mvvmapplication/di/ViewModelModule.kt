package com.example.mvvmapplication.di

import com.example.mvvmapplication.ui.employeelist.EmployeeListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    //    viewModel { EmployeeListViewModel(get(), get()) }

    viewModel { EmployeeListViewModel(get(),get()) }
}