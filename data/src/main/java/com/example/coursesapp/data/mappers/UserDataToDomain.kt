package com.example.coursesapp.data.mappers

import com.example.coursesapp.data.models.UserEntity
import com.example.coursesapp.domain.models.UserModel

class UserDataToDomain() {
    operator fun invoke(userEntity: UserEntity): UserModel = UserModel(userEntity.email)
}