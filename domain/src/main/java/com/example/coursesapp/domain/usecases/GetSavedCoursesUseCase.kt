package com.example.coursesapp.domain.usecases

import com.example.coursesapp.domain.models.CourseModel
import com.example.coursesapp.domain.repositories.CoursesLocalRepository

class GetSavedCoursesUseCase(private val repository: CoursesLocalRepository) {
    suspend operator fun invoke(): List<CourseModel> = repository.getSavedCourses()
}