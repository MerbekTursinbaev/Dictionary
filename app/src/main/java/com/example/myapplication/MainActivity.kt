package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import com.example.myapplication.dao.MyDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mAdapter = MyAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.adapter = mAdapter
        setData()
    }
    private fun setData() {
        val dao = MyDatabase.getInstance(this).dictionaryDao()
        mAdapter.models = dao.getAllDictionary()
    }
}