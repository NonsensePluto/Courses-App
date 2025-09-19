package com.example.coursesapp.domain.usecases

import com.example.coursesapp.domain.models.CourseModel
import com.example.coursesapp.domain.repositories.CoursesLocalRepository

class InsertCourseUseCase(private val repository: CoursesLocalRepository) {
    suspend operator fun invoke(course: CourseModel) = repository.insertCourse(course)
}