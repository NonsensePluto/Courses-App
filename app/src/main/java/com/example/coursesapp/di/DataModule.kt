package com.example.coursesapp.di

import com.example.coursesapp.data.mappers.UserDataToDomain
import com.example.coursesapp.data.repository.LoginRepositoryImpl
import com.example.coursesapp.domain.repository.LoginRepository
import org.koin.dsl.module

val dataModule = module {

    single<LoginRepository> {
        LoginRepositoryImpl(userDataToDomain = get())
    }

    factory<UserDataToDomain> {
        UserDataToDomain()
    }

}