package com.example.kotlinroomdemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinroomdemo.database.entity.Employee
import com.example.kotlinroomdemo.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddRecordViewModel @Inject constructor(private val repository: Repository) :ViewModel(){
    fun insertRecord(employee: Employee){
        viewModelScope.launch {
            repository.insertEmployee(employee)
        }

    }
}