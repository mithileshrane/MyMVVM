package com.example.mvvmapplication.base
import com.google.gson.annotations.SerializedName


open class BaseResponseModel {

    @SerializedName("IsError")
    var IsError: Boolean = false

    @SerializedName("Status")
    var status: Int  = 0

    @SerializedName("Message")
    var Message: String  ? = null

    @SerializedName("LastDtmChecked")
    var LastDtmChecked: String  ? = null


    @SerializedName("ErrorCode")
    var ErrorCode: Int  ? = null

    constructor()

    constructor(isError: Boolean, message: String?, errorCode: Int) {
        this.IsError = isError
        this.status = status
        this.ErrorCode=errorCode
        this.Message = message
        this.LastDtmChecked = message

    }
}
