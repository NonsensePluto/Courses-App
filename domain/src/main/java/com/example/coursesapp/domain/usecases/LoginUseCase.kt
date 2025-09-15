package com.example.coursesapp.domain.usecases

import com.example.coursesapp.domain.repository.LoginRepository

class LoginUseCase(private val repository: LoginRepository) {
    operator fun invoke(email: String, password: String) = repository.login(email, password)
}