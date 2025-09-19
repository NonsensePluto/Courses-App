package com.example.coursesapp.data.repositories

import com.example.coursesapp.data.mappers.UserDataToDomain
import com.example.coursesapp.data.models.UserEntity
import com.example.coursesapp.domain.models.UserModel
import com.example.coursesapp.domain.repositories.LoginRepository

class LoginRepositoryImpl(private val userDataToDomain: UserDataToDomain) : LoginRepository {

    override fun login(email: String, password: String): UserModel {
        val user = UserEntity(email, password)
        return userDataToDomain(user)
    }

    override fun loginWithVk(): String {
        return VK_URL
    }

    override fun loginWithOk(): String {
        return OK_URL
    }

    companion object {
        const val VK_URL = "https://vk.com/"
        const val OK_URL = "https://ok.ru/"
    }
}