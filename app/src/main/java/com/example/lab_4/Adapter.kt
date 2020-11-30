package com.example.lab_4

import android.view.LayoutInflater
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.Toast
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class Adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var taskList = emptyList<Task>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ContactViewHolder(v)

    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as ContactViewHolder
        val currentItem = taskList[position]
        holder.itemView.titleTextView.text = currentItem.title
        holder.itemView.statusTextView.text = currentItem.status
        holder.itemView.categoryTextView.text = currentItem.category

        holder.itemView.toDoItemLayout.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, ItemDetail::class.java).apply {
                putExtra("id", currentItem.id)
                putExtra("title", currentItem.title)
                putExtra("description", currentItem.description)
                putExtra("status", currentItem.status)
                putExtra("category", currentItem.category)
                putExtra("duration", currentItem.duration)
            }
            context.startActivity(intent)
        }

    }

    fun setData(task: List<Task>){

        this.taskList = task
        notifyDataSetChanged()
    }




    inner class ContactViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {




    }




}