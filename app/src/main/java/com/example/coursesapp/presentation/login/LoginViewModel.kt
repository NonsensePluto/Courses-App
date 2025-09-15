package com.example.coursesapp.presentation.login

import androidx.lifecycle.ViewModel
import com.example.coursesapp.domain.usecases.LoginUseCase
import com.example.coursesapp.domain.usecases.LoginWithOkUseCase
import com.example.coursesapp.domain.usecases.LoginWithVkUseCase

class LoginViewModel(
    private val loginUseCase: LoginUseCase,
    private val loginWithVkUseCase: LoginWithVkUseCase,
    private val loginWithOkUseCase: LoginWithOkUseCase
) : ViewModel() {

}