package com.example.mvvmapplication.ui.employeelist

import com.example.mvvmapplication.base.BaseRequestModel

class GetEmployeeListIDRequestModel: BaseRequestModel() {

    var UserId: String? = null

    var LastDtmChecked: String? = null
}