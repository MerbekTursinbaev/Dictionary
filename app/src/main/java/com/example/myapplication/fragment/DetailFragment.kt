package com.example.myapplication.fragment

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.myapplication.R
import kotlinx.android.synthetic.main.fragment_detail.*


class DetailFragment: Fragment(R.layout.fragment_detail) {

    private lateinit var navController: NavController
    private val args: DetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        description.text = args.description

        back.setOnClickListener {
            requireActivity().onBackPressed()
        }

        description.movementMethod = ScrollingMovementMethod()
    }


}