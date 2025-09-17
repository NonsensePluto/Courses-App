package com.example.coursesapp.presentation.mainscreen

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.coursesapp.R
import com.example.coursesapp.databinding.MainScreenBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainScreen() : Fragment(R.layout.main_screen) {

    private val viewModels by viewModel<MainScreenViewModel>()

    private var binding: MainScreenBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = MainScreenBinding.bind(view)

        val courses = viewModels.courses.value

        Log.d("MainScreen", courses.toString())

    }
}