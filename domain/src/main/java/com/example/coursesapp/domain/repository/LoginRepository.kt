package com.example.coursesapp.domain.repository

interface LoginRepository {
    fun login(email: String, password: String)
    fun loginWithVk()
    fun loginWithOk()
}