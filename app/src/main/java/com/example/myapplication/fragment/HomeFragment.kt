package com.example.myapplication.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavAction
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.myapplication.MyAdapter
import com.example.myapplication.R
import com.example.myapplication.dao.MyDao
import com.example.myapplication.dao.MyDatabase
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.*

class HomeFragment: Fragment(R.layout.fragment_home) {

    private val adapter = MyAdapter()
    private lateinit var dao: MyDao
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        recyclerView.adapter = adapter
        dao = MyDatabase.getInstance(requireContext()).dictionaryDao()
        setData()

        adapter.setOnItemClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(it.description)
            navController.navigate(action)
            Toast.makeText(requireContext(), "Item click", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setData(){
        CoroutineScope(Dispatchers.Main).launch {
            adapter.models = withContext(Dispatchers.IO){ dao.getAllDictionary() }
        }
    }
}