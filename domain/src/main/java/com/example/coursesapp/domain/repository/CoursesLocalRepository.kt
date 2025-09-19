package com.example.coursesapp.domain.repository

import com.example.coursesapp.domain.models.CourseModel

interface CoursesLocalRepository {

    suspend fun toggleCourseSaved(course: CourseModel)

}