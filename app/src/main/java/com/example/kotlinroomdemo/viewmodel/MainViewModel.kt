package com.example.kotlinroomdemo.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinroomdemo.database.entity.Employee
import com.example.kotlinroomdemo.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel  @Inject constructor(private  val repository: Repository):ViewModel() {

    fun getAllEmpRecords():LiveData<List<Employee>>?{
        return repository.getRecords()
    }
    fun removeRecord(id:Int){
        viewModelScope.launch {
            repository.deleteRecordById(id)
        }
    }
}