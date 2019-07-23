package com.example.mvvmapplication.ui.employeelist

import androidx.recyclerview.widget.DiffUtil
import com.example.mvvmapplication.data.db.entity.EmployeeListResponseModel

class PostsDiffUtilCallback(private val oldList: List<EmployeeListResponseModel.EmployeeListResult.EmployeeListUserDetail>,
                            private val newList: List<EmployeeListResponseModel.EmployeeListResult.EmployeeListUserDetail>)
    : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) = oldList[oldItemPosition].getUserId()
        .equals( newList[newItemPosition].getUserId())

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) = true
}