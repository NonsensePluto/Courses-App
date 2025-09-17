package com.example.coursesapp.presentation.mainscreen

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.coursesapp.R
import com.example.coursesapp.databinding.MainScreenBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.coursesapp.presentation.mainscreen.utils.CoursesAdapter
import androidx.recyclerview.widget.LinearLayoutManager

class MainScreen() : Fragment(R.layout.main_screen) {

    private val viewModel by viewModel<MainScreenViewModel>()

    private var binding: MainScreenBinding? = null

    private val coursesAdapter by lazy {
        CoursesAdapter(
            onDetailsClick = { course ->  },
            onFavoriteClick = { course ->  }
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = MainScreenBinding.bind(view)

        val courses = viewModel.courses.value

        Log.d("MainScreen", courses.toString())

        binding?.rvCourses?.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = coursesAdapter
        }

        viewModel.courses.observe(viewLifecycleOwner) { list ->
            coursesAdapter.items = list
            coursesAdapter.notifyDataSetChanged()
        }

    }

}