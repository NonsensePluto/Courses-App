package com.example.coursesapp.presentation.bottomnavigation.utils

import androidx.fragment.app.FragmentManager
import com.example.coursesapp.R
import com.example.coursesapp.presentation.account.AccountScreenFragment
import com.example.coursesapp.presentation.mainscreen.MainScreenFragment
import com.example.coursesapp.presentation.navigation.navigate
import com.example.coursesapp.presentation.saved.SavedScreenFragment

enum class BottomNavigationPosition(val position: Int, val menuItemId: Int) {
    MAIN(0, R.id.main_screen_item),
    SAVED(1, R.id.saved_screen_item),
    ACCOUNT(2, R.id.account_screen_item)
}

fun findNavigationPosition(id: Int): BottomNavigationPosition = when (id) {
    BottomNavigationPosition.MAIN.menuItemId -> BottomNavigationPosition.MAIN
    BottomNavigationPosition.SAVED.menuItemId -> BottomNavigationPosition.SAVED
    BottomNavigationPosition.ACCOUNT.menuItemId -> BottomNavigationPosition.ACCOUNT
    else -> BottomNavigationPosition.MAIN
}

fun openFragment(fragmentManager: FragmentManager, position: BottomNavigationPosition) {
    val fragment = when (position) {
        BottomNavigationPosition.MAIN -> MainScreenFragment()
        BottomNavigationPosition.SAVED -> SavedScreenFragment()
        BottomNavigationPosition.ACCOUNT -> AccountScreenFragment()
    }

    navigate(fragmentManager, fragment, containerId = R.id.fragmentContainer)
}

