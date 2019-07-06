package com.itgs.tradepartners.base

import com.example.mvvmapplication.base.BaseView
import com.itgs.tradepartners.R
import com.itgs.tradepartners.application.App
import com.itgs.tradepartners.utils.Constant
import retrofit2.Call
import retrofit2.Callback
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.util.concurrent.TimeoutException


abstract class CallbackWithRetry<T> : Callback<T> {

    constructor(mView: BaseView){
        this.mView=mView
    }
    companion object {
        val TOTAL_RETRIES = 3

    }

    private var retryCount = 0
    private var mView : BaseView?=null

    override fun onFailure(call: Call<T>, t: Throwable) {
        if (retryCount++ < TOTAL_RETRIES) {
            retry(call)

        } else {
            if (t is ConnectException) {
                Constant.showToast(
                    App.getApplicationContextImpl(),
                    App.getApplicationContextImpl().resources.getString(R.string.txt_no_internet_connection)
                )
            } else if (t is SocketTimeoutException) {
                Constant.showToast(
                    App.getApplicationContextImpl(), App.getApplicationContextImpl()
                        .resources.getString(R.string.txt_socket_time_out_excpetion)
                )
            } else if (t is TimeoutException) {
                Constant.showToast(
                    App.getApplicationContextImpl(), App.getApplicationContextImpl()
                        .resources.getString(R.string.txt_time_out_excpetion)
                )
            } else
                Constant.showToast(
                    App.getApplicationContextImpl(), App.getApplicationContextImpl()
                        .resources.getString(R.string.txt_something_went_wrong)
                )

            mView?.hideProgress()
        }


    }

    private fun retry(call: Call<T>) {
        call.clone().enqueue(this)
    }
}