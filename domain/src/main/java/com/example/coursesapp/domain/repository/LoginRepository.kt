package com.example.coursesapp.domain.repository

import com.example.coursesapp.domain.models.UserModel

interface LoginRepository {
    fun login(email: String, password: String): UserModel
    fun loginWithVk(): String
    fun loginWithOk(): String
}