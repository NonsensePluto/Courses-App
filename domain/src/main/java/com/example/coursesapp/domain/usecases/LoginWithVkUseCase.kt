package com.example.coursesapp.domain.usecases

import com.example.coursesapp.domain.repositories.LoginRepository

class LoginWithVkUseCase(private val repository: LoginRepository) {
    operator fun invoke(): String = repository.loginWithVk()
}