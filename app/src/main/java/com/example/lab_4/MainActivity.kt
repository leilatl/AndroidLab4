package com.example.lab_4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    I DON'T KNOW HOW TO WORK WITH FRAGMENTS PROPERLY, THAT'S WHY I USED AN ACTIVITY FOR DETAIL PAGE :)

    private val fragmentManager = supportFragmentManager
    lateinit var db: AppDatabase
    lateinit var taskDao: TaskDao


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val firstFragment = FragmentList()
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.toDoListLayout, firstFragment)
        fragmentTransaction.commit()

        addButton.setOnClickListener {
            val intent = Intent(this, InputToDo::class.java)
            startActivity(intent)

        }
    }
}
