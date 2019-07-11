package com.example.mvvmapplication.ui.employeelist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmapplication.base.BaseViewModel
import com.example.mvvmapplication.data.constant.APIConstants
import com.example.mvvmapplication.data.constant.Constant
import com.example.mvvmapplication.data.db.dao.EmployeeDao
import com.example.mvvmapplication.data.db.entity.EmployeeListResponseModel
import com.example.mvvmapplication.data.hmac.HMACClient
import com.example.mvvmapplication.data.remote.api.ApiClient
import com.example.mvvmapplication.extensions.lazyDeferred
import com.example.mvvmapplication.extensions.with
import com.example.mvvmapplication.util.NotNullMutableLiveData
import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class EmployeeListViewModel(private val apiClient: ApiClient, private val dao: EmployeeDao) : BaseViewModel() {

     val _items by lazyDeferred()
     {
         getAll()
     }

    suspend fun getAll(): LiveData<out List<EmployeeListResponseModel.EmployeeListResult.EmployeeListUserDetail>?> {

//        return newsDao!!.getAllNews()
        return GlobalScope.async {
            return@async dao.findAll()
        }.await()
    }

    fun call() {
        val requestmodel = GetEmployeeListIDRequestModel()
        requestmodel.CommandType = APIConstants.GET_EMPLOYEELISTBY_ID
        requestmodel.UserId = "15a16afa-b507-4146-9809-c3b193e6b6ee"
        requestmodel.DeviceToken = "6c931989-2bee-42f7-9d9c-dbacd308cc44"
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

       /* addToDisposable(apiClient.getEmployeeListByID(requestmodel).with().subscribe({

            val responseModel = Gson().fromJson(
                it
                , EmployeeListResponseModel::class.java
            )
            if( responseModel.getResult()!=null){
            _items.value = responseModel.getResult()?.getUserDetail()!!

            GlobalScope.async {
                dao.insert(responseModel.getResult()?.getUserDetail()!!)
            }
            }
        }, {

            it.message
        }))*/

        addToDisposable(apiClient.getEmployeeListByID(requestmodel).with().subscribe({
            val isValid=HMACClient.parseResponse(it,it.body()!!)
            if (isValid){
                val responseModel = Gson().fromJson(
                    it.body()
                    , EmployeeListResponseModel::class.java
                )

                if( responseModel.getResult()!=null){


                    GlobalScope.async {
                        try {
                            val inserted= dao.insertAll(responseModel.getResult()?.getUserDetail()!!)
                            Log.d("REQ:","inserted: $inserted")

                            val lsit= dao.findAll()
                            _items.value = lsit
                            _items.postValue(lsit)
                            Log.d("REQ:","lsit size: ${lsit.size}")
                        } catch (e: Exception) {
                            e.message
                        }
                    }
                }
            }else{

            }

        }, {

            it.message
        }))


        /*addToDisposable(apiClient.getEmployeeListByID(requestmodel).with().subscribe({
            val isValid = HMACClient.parseResponse(it, it.body()!!)
            if (isValid) {
                val responseModel = Gson().fromJson(
                    it
                    , EmployeeListResponseModel::class.java
                )
                if (responseModel.getResult() != null) {
                    _items.value = responseModel.getResult()?.getUserDetail()!!

                    GlobalScope.async {
                        dao.insert(responseModel.getResult()?.getUserDetail()!!)
                    }
                }
            }

        }, {
            it.message
        }))
*/
    }


}
