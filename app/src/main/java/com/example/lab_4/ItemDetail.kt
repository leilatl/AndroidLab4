package com.example.lab_4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_item_detail.*

class ItemDetail : AppCompatActivity() {

    private var id:String? = null
    private var title:String? = null
    private var description:String? = null
    private var status:String? = null
    private var category:String? = null
    private var duration:String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)
        id = intent.getStringExtra("id")
        title = intent.getStringExtra("title")
        description = intent.getStringExtra("description")
        status = intent.getStringExtra("status")
        category = intent.getStringExtra("category")
        duration = intent.getStringExtra("duration")
        idTextView.text = "ID: $id"
        titleTextView.text = "Title: $title"
        descriptionTextView.text = "Description: $description"
        statusTextView.text = "Status: $status"
        categoryTextView.text = "Category: $category"
        durationTextView.text = "Durations: $duration minutes"
    }
}
