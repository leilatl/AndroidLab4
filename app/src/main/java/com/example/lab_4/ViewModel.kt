package com.example.lab_4

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel(application: Application): AndroidViewModel(application) {
    val getAll: LiveData<List<Task>>
    private val repository: Repository
    init {
        val taskDao = AppDatabase.getDatabase(application).taskDao()
        repository = Repository(taskDao)
        getAll = repository.readAllData
    }
    fun addTask(task: Task){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addTask(task)
        }
    }
}