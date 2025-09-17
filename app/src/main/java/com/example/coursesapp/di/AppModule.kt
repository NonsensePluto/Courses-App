package com.example.coursesapp.di

import com.example.coursesapp.presentation.login.LoginViewModel
import com.example.coursesapp.presentation.mainscreen.MainScreenViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<LoginViewModel> {
        LoginViewModel(
            loginUseCase = get(),
            loginWithVkUseCase = get(),
            loginWithOkUseCase = get()
        )
    }

    viewModel<MainScreenViewModel> {
        MainScreenViewModel(
            getAllCoursesUseCase = get()
        )
    }
}