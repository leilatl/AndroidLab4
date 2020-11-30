package com.example.lab_4

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_input_to_do.*

class InputToDo : AppCompatActivity() {
    private lateinit var mViewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_to_do)

        mViewModel = ViewModelProvider(this).get(ViewModel::class.java)

        addNewItemButton.setOnClickListener {
            insertDatatoDatabase()
        }
    }

    private fun insertDatatoDatabase() {
        val id = idEditText.text.toString().toInt()
        val title = titleEditText.text.toString()
        val description = descriptionEditText.text.toString()
        val status = statusEditText.text.toString()
        val category = categoryEditText.text.toString()
        val duration = durationEditText.text.toString()
        val task = Task(0, title, description, status, category, duration)
        mViewModel.addTask(task)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}