package com.example.mvvmapplication.ui.employeelist

import androidx.lifecycle.ViewModel;
import com.example.mvvmapplication.base.BaseViewModel
import com.example.mvvmapplication.data.db.dao.EmployeeDao
import com.example.mvvmapplication.di.apiModule

class EmployeeListViewModel (private val dao: EmployeeDao) : BaseViewModel() {


}
