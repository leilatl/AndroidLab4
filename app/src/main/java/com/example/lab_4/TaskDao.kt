package com.example.lab_4

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TaskDao {
    @Query("SELECT * FROM toDoList")
    fun getAll(): LiveData<List<Task>>

    @Query("SELECT * FROM toDoList WHERE ID = :id")
    fun getById(id: Int): Task

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(tasks: Task)

    @Delete
    fun delete(task: Task)

    @Update
    fun update(task: Task)
}