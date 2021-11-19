package com.example.myapplication.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.myapplication.IsSelectedAdapter
import com.example.myapplication.R
import com.example.myapplication.dao.MyDao
import com.example.myapplication.dao.MyDatabase
import kotlinx.android.synthetic.main.fragment_favorite.*

class FavoriteFragment : Fragment(R.layout.fragment_favorite) {

    var adapter = IsSelectedAdapter()
    lateinit var dao:MyDao

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dao = MyDatabase.getInstance(requireContext()).dictionaryDao()
        adapter.modelsSelected = dao.getFavorites()
        recyclerSelectedView.adapter = adapter
    }
}