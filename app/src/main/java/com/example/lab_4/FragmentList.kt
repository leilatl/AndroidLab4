package com.example.lab_4

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.fragment_list.view.*

class FragmentList : Fragment() {
    private lateinit var mViewModel: ViewModel
    private var toDoAdapter: Adapter? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        val adapter = Adapter()
        val recyclerView = view.toDoRecyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        mViewModel = ViewModelProvider(this).get(ViewModel::class.java)
        mViewModel.getAll.observe(viewLifecycleOwner, Observer {user ->
            adapter.setData(user)
        })
        return view
    }



}