package com.example.coursesapp.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coursesapp.domain.models.UserModel
import com.example.coursesapp.domain.usecases.LoginUseCase
import com.example.coursesapp.domain.usecases.LoginWithOkUseCase
import com.example.coursesapp.domain.usecases.LoginWithVkUseCase

class LoginViewModel(
    private val loginUseCase: LoginUseCase,
    private val loginWithVkUseCase: LoginWithVkUseCase,
    private val loginWithOkUseCase: LoginWithOkUseCase
) : ViewModel() {

    private val _urlString = MutableLiveData<String>()
    val urlString: LiveData<String> get() = _urlString

    fun login(email: String, password: String): UserModel = loginUseCase(email, password)

    fun loginWithVk() {
        _urlString.value = loginWithVkUseCase()
    }

    fun loginWithOk() {
        _urlString.value = loginWithOkUseCase()
    }
}