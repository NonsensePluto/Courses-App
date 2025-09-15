package com.example.coursesapp.domain.usecases

import com.example.coursesapp.domain.repository.LoginRepository

class LoginWithOkUseCase(private val repository: LoginRepository) {
    operator fun invoke() = repository.loginWithOk()
}