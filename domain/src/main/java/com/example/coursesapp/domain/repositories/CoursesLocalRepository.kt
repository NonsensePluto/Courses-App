package com.example.coursesapp.domain.repositories

import com.example.coursesapp.domain.models.CourseModel

interface CoursesLocalRepository {

    suspend fun toggleCourseSaved(course: CourseModel)

    suspend fun insertCourse(course: CourseModel)

    suspend fun isCourseSaved(courseId: Int): Boolean

    suspend fun getSavedCourses(): List<CourseModel>
}