package com.example.kotlinroomdemo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kotlinroomdemo.database.dao.EmployeeDao
import com.example.kotlinroomdemo.database.entity.Employee

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = [Employee::class], version = 1, exportSchema = false)
public abstract class EmployeeDatabase : RoomDatabase() {

    abstract fun employeeDao(): EmployeeDao

//    companion object {
//        // Singleton prevents multiple instances of database opening at the
//        // same time.
//        @Volatile
//        private var INSTANCE: EmployeeDatabase? = null
//
//        fun getDatabase(context: Context): EmployeeDatabase {
//            // if the INSTANCE is not null, then return it,
//            // if it is, then create the database
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    EmployeeDatabase::class.java,
//                    "employee_database"
//                ).build()
//                INSTANCE = instance
//                // return instance
//                instance
//            }
//        }
//    }
}
