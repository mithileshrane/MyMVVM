package com.example.mvvmapplication.data.db.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.example.mvvmapplication.data.db.entity.EmployeeListResponseModel
import androidx.paging.DataSource
import java.util.ArrayList


@Dao
interface EmployeeDao {
    /*    @Query("SELECT * FROM employees ORDER BY fname ASC")
      suspend fun findAll(): DataSource.Factory<Int, EmployeeListResponseModel.EmployeeListResult.EmployeeListUserDetail>*/

    @Query("SELECT * FROM employees ORDER BY fname ASC")
    suspend fun findAll(): LiveData<List<EmployeeListResponseModel.EmployeeListResult.EmployeeListUserDetail>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(employee: EmployeeListResponseModel.EmployeeListResult.EmployeeListUserDetail)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: ArrayList<EmployeeListResponseModel.EmployeeListResult.EmployeeListUserDetail>)

/*
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg entity: employees)
*/

    @Delete
    suspend fun delete(employee: EmployeeListResponseModel.EmployeeListResult.EmployeeListUserDetail)
}