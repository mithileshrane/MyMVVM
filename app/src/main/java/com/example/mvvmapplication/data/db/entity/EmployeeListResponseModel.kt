package com.example.mvvmapplication.data.db.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mvvmapplication.base.BaseResponseModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class EmployeeListResponseModel() : BaseResponseModel(), Parcelable
{
    @SerializedName("Result")
    @Expose
    private var result: EmployeeListResult? = null

    constructor(parcel: Parcel) : this() {

    }

    fun getResult(): EmployeeListResult? {
        return result
    }

    fun setResult(result: EmployeeListResult) {
        this.result = result
    }

    class EmployeeListResult(): Parcelable
    {
        @SerializedName("userDetail")
        @Expose
        private var userDetail: ArrayList<EmployeeListUserDetail>? = null
        @SerializedName("LastDtmChecked")
        @Expose
        private var lastDtmChecked: String? = null

        constructor(parcel: Parcel) : this() {
            lastDtmChecked = parcel.readString()
        }

        fun getUserDetail(): ArrayList<EmployeeListUserDetail>? {
            return userDetail
        }

        fun setUserDetail(userDetail: ArrayList<EmployeeListUserDetail>) {
            this.userDetail = userDetail
        }

        fun getLastDtmChecked(): String? {
            return lastDtmChecked
        }

        fun setLastDtmChecked(lastDtmChecked: String) {
            this.lastDtmChecked = lastDtmChecked
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeString(lastDtmChecked)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<EmployeeListResult> {
            override fun createFromParcel(parcel: Parcel): EmployeeListResult {
                return EmployeeListResult(parcel)
            }

            override fun newArray(size: Int): Array<EmployeeListResult?> {
                return arrayOfNulls(size)
            }
        }

        @Entity(tableName = "employees")
        class EmployeeListUserDetail() : Parcelable
        {
            @NonNull
            @PrimaryKey
            @SerializedName("UserId")
            @Expose
            private var userId: String? = null

            @ColumnInfo(name = "fname")
            @SerializedName("FirstName")
            @Expose
            private var firstName: String? = null

            @ColumnInfo(name = "lname")
            @SerializedName("Lastname")
            @Expose
            private var lastName: String? = null

            @ColumnInfo(name = "profileimg")
            @SerializedName("Image")
            @Expose
            private var image: String? = null

            @ColumnInfo(name = "visitType")
            @SerializedName("VisitType")
            @Expose
            private var visitType: String? = null

            @ColumnInfo(name = "designationId")
            @SerializedName("DesignationId")
            @Expose
            private var designationId: String? = null

            @ColumnInfo(name = "designation")
            @SerializedName("Designation")
            @Expose
            private var designation: String? = null

            @ColumnInfo(name = "isDeleted")
            @SerializedName("IsDeleted")
            @Expose
            private var isDeleted: Boolean? = null

            constructor(parcel: Parcel) : this() {
                userId = parcel.readString()
                firstName = parcel.readString()
                lastName = parcel.readString()
                image = parcel.readString()
                designationId = parcel.readString()
                designation = parcel.readString()
                isDeleted = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
            }

            fun getUserId(): String? {
                return userId
            }

            fun setUserId(userId: String) {
                this.userId = userId
            }

            fun getFirstName(): String? {
                return firstName
            }

            fun setFirstName(firstName: String) {
                this.firstName = firstName
            }

            fun getLastName(): String? {
                return lastName
            }

            fun setLastName(lastname: String) {
                this.lastName = lastname
            }

            fun getImage(): String? {
                return image
            }

            fun setImage(image: String?) {
                this.image = image
            }

            fun getVisitType(): String? {
                return visitType
            }

            fun setVisitType(visitType: String) {
                this.visitType = visitType
            }

            fun getDesignationId(): String? {
                return designationId
            }

            fun setDesignationId(designationId: String) {
                this.designationId = designationId
            }

            fun getDesignation(): String? {
                return designation
            }

            fun setDesignation(designation: String) {
                this.designation = designation
            }

            fun getIsDeleted(): Boolean? {
                return isDeleted
            }

            fun setIsDeleted(isDeleted: Boolean?) {
                this.isDeleted = isDeleted
            }

            override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeString(userId)
                parcel.writeString(firstName)
                parcel.writeString(lastName)
                parcel.writeString(image)
                parcel.writeValue(designationId)
                parcel.writeString(designation)
                parcel.writeValue(isDeleted)
            }

            override fun describeContents(): Int {
                return 0
            }

            companion object CREATOR : Parcelable.Creator<EmployeeListUserDetail> {
                override fun createFromParcel(parcel: Parcel): EmployeeListUserDetail {
                    return EmployeeListUserDetail(
                        parcel
                    )
                }

                override fun newArray(size: Int): Array<EmployeeListUserDetail?> {
                    return arrayOfNulls(size)
                }
            }
        }
    }



    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<EmployeeListResponseModel> {
        override fun createFromParcel(parcel: Parcel): EmployeeListResponseModel {
            return EmployeeListResponseModel(parcel)
        }

        override fun newArray(size: Int): Array<EmployeeListResponseModel?> {
            return arrayOfNulls(size)
        }
    }
}