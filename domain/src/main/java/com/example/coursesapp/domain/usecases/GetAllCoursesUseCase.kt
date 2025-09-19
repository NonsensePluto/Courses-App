package com.example.coursesapp.domain.usecases

import com.example.coursesapp.domain.repositories.CoursesRemoteRepository

class GetAllCoursesUseCase(private val repository: CoursesRemoteRepository) {
    suspend operator fun invoke() = repository.getAllCourses()
}