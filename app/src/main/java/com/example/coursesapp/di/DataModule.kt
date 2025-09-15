package com.example.coursesapp.di

import com.example.coursesapp.data.repository.LoginRepositoryImpl
import org.koin.dsl.module

val dataModule = module {

    single<LoginRepositoryImpl> {
        LoginRepositoryImpl()
    }

}