package com.example.coursesapp.presentation.bottomnavigation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.coursesapp.R
import com.example.coursesapp.databinding.NavigationScreenBinding
import com.example.coursesapp.presentation.bottomnavigation.utils.BottomNavigationPosition
import com.example.coursesapp.presentation.bottomnavigation.utils.findNavigationPosition
import com.example.coursesapp.presentation.bottomnavigation.utils.openFragment

class BottomNavigation() : Fragment(R.layout.navigation_screen) {

    private var binding: NavigationScreenBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = NavigationScreenBinding.bind(view)

        if (savedInstanceState == null) {
            openFragment(fragmentManager = parentFragmentManager, position = BottomNavigationPosition.MAIN)
        }

        binding?.bottomNavigation?.setOnItemSelectedListener { menuItem ->
            val position = findNavigationPosition(menuItem.itemId)
            openFragment(fragmentManager = parentFragmentManager, position = position)
            true
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}