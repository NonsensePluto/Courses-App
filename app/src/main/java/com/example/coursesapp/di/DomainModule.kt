package com.example.coursesapp.di

import com.example.coursesapp.domain.usecases.GetAllCoursesUseCase
import com.example.coursesapp.domain.usecases.LoginUseCase
import com.example.coursesapp.domain.usecases.LoginWithOkUseCase
import com.example.coursesapp.domain.usecases.LoginWithVkUseCase
import com.example.coursesapp.domain.usecases.ToggleCourseSavedUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<LoginUseCase> {
        LoginUseCase(repository = get())
    }

    factory<LoginWithVkUseCase> {
        LoginWithVkUseCase(repository = get())
    }

    factory<LoginWithOkUseCase> {
        LoginWithOkUseCase(repository = get())
    }

    factory<GetAllCoursesUseCase> {
        GetAllCoursesUseCase(repository = get())
    }

    factory<ToggleCourseSavedUseCase> {
        ToggleCourseSavedUseCase(repository = get())
    }

}