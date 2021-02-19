package com.example.kotlinroomdemo.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.kotlinroomdemo.database.entity.Employee

@Dao
interface EmployeeDao {
    @Insert
    suspend fun insert(employee: Employee)

    @Query("Select * from employee")
    fun getAllEmployees(): LiveData<List<Employee>>

    @Query("Delete from employee where empId = (:id)")
    suspend fun deleteById(id:Int)

    @Update
    suspend fun update(employee: Employee)
}