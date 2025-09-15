package com.example.coursesapp.presentation.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.coursesapp.R

fun navigate(fragmentManager: FragmentManager, fragment: Fragment, addToBackStack: Boolean = true) {
    if (addToBackStack) {
        fragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .addToBackStack(null)
            .commit()
        return
    }
    fragmentManager.beginTransaction()
        .replace(R.id.fragmentContainer, fragment)
        .commit()
}