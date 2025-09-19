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


    //Сохраняю пользователя без пароля, можно использовать потом, например для отображения на экране "Аккаунт"
    private val _userModel = MutableLiveData<UserModel>()
    val userModel: LiveData<UserModel> get() = _userModel

    fun login(email: String, password: String) {
        val user = loginUseCase(email, password)
        _userModel.value = user
    }

    fun loginWithVk() {
        _urlString.value = loginWithVkUseCase()
    }

    fun loginWithOk() {
        _urlString.value = loginWithOkUseCase()
    }
}