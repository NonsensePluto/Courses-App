package com.example.coursesapp.domain.repositories

import com.example.coursesapp.domain.models.CourseModel

interface CoursesRemoteRepository {

    suspend fun getAllCourses(): List<CourseModel>

}