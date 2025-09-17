package com.example.coursesapp.data.remote.datasource

import com.example.coursesapp.data.remote.api.CoursesApi
import com.example.coursesapp.data.remote.models.CourseResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CoursesRemoteDataSource(
    private val api: CoursesApi
) {
    suspend fun downloadCourses(): List<CourseResponse> = withContext(Dispatchers.IO) {
        api.downloadCoursesJson().courses
    }
}
