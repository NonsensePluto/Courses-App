package com.example.coursesapp.presentation.login

import androidx.fragment.app.Fragment
import com.example.coursesapp.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginScreen() : Fragment(R.layout.login_screen) {

    private val viewModel by viewModel<LoginViewModel>()



}