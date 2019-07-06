package com.example.mvvmapplication.base

interface BaseView{
    abstract fun showError(stringResID: Int)

    abstract fun showError(errrorMsg: String)

    abstract fun onSuccess()

    abstract fun onFailure()

    fun showProgress()
    fun hideProgress()
    abstract fun showToast(stringResID: Int)

    abstract fun showToast(errrorMsg: String)

    //For the token expired
    fun tokenExpired()

}