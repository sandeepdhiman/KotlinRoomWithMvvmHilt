package com.example.kotlinroomdemo.di

import android.content.Context
import androidx.room.Room
import com.example.kotlinroomdemo.database.EmployeeDatabase
import com.example.kotlinroomdemo.database.dao.EmployeeDao
import com.example.kotlinroomdemo.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    fun provideChannelDao(appDatabase: EmployeeDatabase): EmployeeDao {
        return appDatabase.employeeDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): EmployeeDatabase {
        return Room.databaseBuilder(
            appContext,
            EmployeeDatabase::class.java,
            "employee_database"
        ).build()
    }
    @Provides
    fun provideRepository(employeeDao: EmployeeDao) = Repository(employeeDao)
}