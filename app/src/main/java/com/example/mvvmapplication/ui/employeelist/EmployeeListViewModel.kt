package com.example.mvvmapplication.ui.employeelist

import android.util.Log
import com.example.mvvmapplication.base.BaseViewModel
import com.example.mvvmapplication.data.constant.APIConstants
import com.example.mvvmapplication.data.constant.Constant
import com.example.mvvmapplication.data.db.dao.EmployeeDao
import com.example.mvvmapplication.data.db.entity.EmployeeListResponseModel
import com.example.mvvmapplication.data.remote.api.ApiClient
import com.example.mvvmapplication.extensions.with
import com.example.mvvmapplication.util.NotNullMutableLiveData
import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class EmployeeListViewModel(private val apiClient: ApiClient, private val dao: EmployeeDao) : BaseViewModel() {

    private val _items:
            NotNullMutableLiveData<List<EmployeeListResponseModel.EmployeeListResult.EmployeeListUserDetail>> =
        NotNullMutableLiveData(arrayListOf())


    fun call() {
        val requestmodel = GetEmployeeListIDRequestModel()
        requestmodel.CommandType = APIConstants.GET_EMPLOYEELISTBY_ID
        requestmodel.UserId = "15a16afa-b507-4146-9809-c3b193e6b6ee"
        requestmodel.DeviceToken = "adbb1843-f23a-4385-9d14-fcd9e9798246"
//            requestmodel.LastDtmChecked = SessionManager.getLastDtmEmployeeList()
        //Change offline logic for extra f;ag in table at api
        requestmodel.LastDtmChecked = ""
        Constant.showLog("REQRES", Gson().toJson(requestmodel), Log.DEBUG)

        /*addToDisposable(api.search(params).with()
            .doOnSubscribe { _refreshing.value = true }
            .doOnSuccess { _refreshing.value = false }
            .doOnError { _refreshing.value = false }
            .subscribe({

            }, {
                // handle errors
            })
        )*/

        addToDisposable(apiClient.getEmployeeListByID(requestmodel).with().subscribe({
            val responseModel = Gson().fromJson(
                it
                , EmployeeListResponseModel::class.java
            )
            _items.value = responseModel.getResult()?.getUserDetail()!!

            GlobalScope.async {
                dao.insert(responseModel.getResult()?.getUserDetail()!!)
            }
        }, {

            it.message
        }))

    }
}
