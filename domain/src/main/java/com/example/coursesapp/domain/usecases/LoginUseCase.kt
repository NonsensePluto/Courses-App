package com.example.coursesapp.domain.usecases

import com.example.coursesapp.domain.models.UserModel
import com.example.coursesapp.domain.repositories.LoginRepository

class LoginUseCase(private val repository: LoginRepository) {
    operator fun invoke(email: String, password: String): UserModel = repository.login(email, password)
}