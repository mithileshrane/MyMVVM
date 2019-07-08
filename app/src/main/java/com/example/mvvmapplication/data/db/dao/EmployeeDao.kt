package com.example.mvvmapplication.data.db.dao

import androidx.room.*
import com.example.mvvmapplication.data.db.entity.EmployeeListResponseModel
import androidx.paging.DataSource
import java.util.ArrayList


@Dao
interface EmployeeDao {
    /*    @Query("SELECT * FROM employees ORDER BY fname ASC")
      suspend fun findAll(): DataSource.Factory<Int, EmployeeListResponseModel.EmployeeListResult.EmployeeListUserDetail>*/

    @Query("SELECT * FROM employees ORDER BY fname ASC")
    suspend fun findAll(): MutableList<EmployeeListResponseModel.EmployeeListResult.EmployeeListUserDetail>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(employee: EmployeeListResponseModel.EmployeeListResult.EmployeeListUserDetail)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(list: ArrayList<EmployeeListResponseModel.EmployeeListResult.EmployeeListUserDetail>)


    @Delete
    suspend fun delete(employee: EmployeeListResponseModel.EmployeeListResult.EmployeeListUserDetail)
}