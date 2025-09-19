package com.example.coursesapp.di

import androidx.room.Room
import com.example.coursesapp.data.local.appdatabase.AppDatabase
import com.example.coursesapp.data.local.dao.CourseDao
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

val databaseModule = module {

    single<AppDatabase> {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "app_database"
        ).build()
    }

    single<CourseDao> {
        get<AppDatabase>().courseDao()
    }
}