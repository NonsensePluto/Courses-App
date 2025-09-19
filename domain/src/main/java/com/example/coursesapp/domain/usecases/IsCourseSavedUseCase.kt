package com.example.coursesapp.domain.usecases

import com.example.coursesapp.domain.repositories.CoursesLocalRepository

class IsCourseSavedUseCase(private val repository: CoursesLocalRepository) {
    suspend operator fun invoke(courseId: Int) = repository.isCourseSaved(courseId)
}