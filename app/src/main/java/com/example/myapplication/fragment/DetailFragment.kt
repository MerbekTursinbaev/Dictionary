package com.example.myapplication.fragment

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.myapplication.R
import com.example.myapplication.dao.MyDao
import com.example.myapplication.dao.MyDatabase
import com.example.myapplication.dao.User
import kotlinx.android.synthetic.main.fragment_detail.*


class DetailFragment: Fragment(R.layout.fragment_detail) {

    private lateinit var navController: NavController
    private val args: DetailFragmentArgs by navArgs()
    private lateinit var dao: MyDao
    private lateinit var user: User
    private var menuItem: MenuItem? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        dao = MyDatabase.getInstance(requireContext()).dictionaryDao()

        description.text = args.description
        // args.id
        user = dao.getUserById( args.id )

        back.setOnClickListener {
            requireActivity().onBackPressed()
        }

        description.movementMethod = ScrollingMovementMethod()

        setFavoriteIcon()
        isFavorite.setOnClickListener {
            setFavorite()
        }
    }

    private fun setFavorite() {
        if (user.isFavorite == 0) {
            user.isFavorite = 1
        } else user.isFavorite = 0
        setFavoriteIcon()
        dao.update(user)
    }

    private fun setFavoriteIcon() {
        if (user.isFavorite == 1) {
            menuItem?.setIcon(R.drawable.ic_baseline_bookmark_24)
        } else {
            menuItem?.setIcon(R.drawable.ic_baseline_bookmark_border_24)
        }
    }
}