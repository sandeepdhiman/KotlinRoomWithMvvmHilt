package com.example.kotlinroomdemo.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employee")
data class Employee(
    @ColumnInfo(name="name")
    var name :String,
    @ColumnInfo(name ="fatherName")
    var fatherName:String,
    @ColumnInfo(name="email")
    var email :String,
    @ColumnInfo(name="mobileNumber")
    var mobileNumber :String,
    @ColumnInfo(name="department")
    var department:String
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="empId")
    var empId :Int? = null

}