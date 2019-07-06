package com.example.mvvmapplication.data.db.dao

import androidx.room.*
import com.example.mvvmapplication.data.db.entity.EmployeeListResponseModel
import androidx.paging.DataSource


@Dao
interface EmployeeDao {
    suspend @Query("SELECT * FROM employees ORDER BY fname ASC")
    fun findAll(): DataSource.Factory<Int, EmployeeListResponseModel.EmployeeListResult.EmployeeListUserDetail>

    suspend @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(employee: EmployeeListResponseModel.EmployeeListResult.EmployeeListUserDetail)

    suspend @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(employeeList: List<EmployeeListResponseModel.EmployeeListResult.EmployeeListUserDetail>)

    suspend @Delete
    fun delete(employee: EmployeeListResponseModel.EmployeeListResult.EmployeeListUserDetail)
}