package com.example.kotlinroomdemo.repository

import androidx.lifecycle.LiveData
import com.example.kotlinroomdemo.database.dao.EmployeeDao
import com.example.kotlinroomdemo.database.entity.Employee
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class Repository @Inject constructor(private val employeeDao: EmployeeDao) {

    suspend fun insertEmployee(employee: Employee){
        withContext(Dispatchers.IO){
            employeeDao.insert(employee)
        }

    }

    fun getRecords():LiveData<List<Employee>>?{

            return employeeDao.getAllEmployees()
    }

    suspend fun deleteRecordById(id:Int){
        withContext(Dispatchers.IO){
            employeeDao.deleteById(id)
        }
    }
}