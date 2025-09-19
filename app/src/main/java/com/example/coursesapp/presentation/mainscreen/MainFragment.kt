package com.example.coursesapp.presentation.mainscreen

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.coursesapp.R
import com.example.coursesapp.databinding.MainFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.coursesapp.presentation.mainscreen.utils.CoursesAdapter
import androidx.recyclerview.widget.LinearLayoutManager

class MainFragment() : Fragment(R.layout.main_fragment) {

    private val viewModel by viewModel<MainViewModel>()

    private var binding: MainFragmentBinding? = null

    private val coursesAdapter by lazy {
        CoursesAdapter(
            onDetailsClick = { course -> },
            onFavoriteClick = { course ->
                viewModel.toggleSavedCourse(course)
            }
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = MainFragmentBinding.bind(view)

        setupRecyclerView()
        setupListeners()

    }

    private fun setupRecyclerView() {
        binding?.rvCourses?.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = coursesAdapter
        }

        viewModel.courses.observe(viewLifecycleOwner) { list ->
            coursesAdapter.items = list
            coursesAdapter.notifyDataSetChanged()
        }
    }

    private fun setupListeners() {
        binding?.tvSortBy?.setOnClickListener {
            viewModel.sortCoursesByDate()
        }

        viewModel.loading.observe(viewLifecycleOwner) { isLoading ->
            binding?.pbLoading?.visibility = if (isLoading) View.VISIBLE else View.GONE
        }

        viewModel.error.observe(viewLifecycleOwner) { error ->
            Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
        }
    }

}