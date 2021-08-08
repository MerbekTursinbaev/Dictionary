package com.example.myapplication.fragment

import androidx.fragment.app.Fragment
import com.example.myapplication.MyAdapter
import com.example.myapplication.R
import com.example.myapplication.dao.MyDatabase
import kotlinx.android.synthetic.main.view_fragment.*


class ViewFragment : Fragment(R.layout.view_fragment) {
    private fun View() {
        recyclerView.adapter = MyAdapter()
        val dao = MyDatabase.getInstance(this).dictionaryDao()
        MyAdapter().models = dao.getAllDictionary()
    }
}