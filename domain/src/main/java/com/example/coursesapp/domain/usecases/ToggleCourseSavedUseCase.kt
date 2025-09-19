package com.example.coursesapp.domain.usecases

import com.example.coursesapp.domain.models.CourseModel
import com.example.coursesapp.domain.repository.CoursesLocalRepository

class ToggleCourseSavedUseCase(private val repository: CoursesLocalRepository) {
    suspend operator fun invoke(course: CourseModel) = repository.toggleCourseSaved(course)
}