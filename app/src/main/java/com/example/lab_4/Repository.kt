package com.example.lab_4

import androidx.lifecycle.LiveData

class Repository(private val taskDao: TaskDao) {
    val readAllData: LiveData<List<Task>> = taskDao.getAll()
    suspend fun addTask(task: Task){
        taskDao.insertAll(task)
    }
}