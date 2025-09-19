package com.example.coursesapp.data.repositories

import com.example.coursesapp.data.mappers.CourseResponseToDomain
import com.example.coursesapp.data.remote.datasource.CoursesRemoteDataSource
import com.example.coursesapp.domain.models.CourseModel
import com.example.coursesapp.domain.repositories.CoursesRemoteRepository

class CoursesRemoteRepositoryImpl(
    private val coursesRemoteDataSource: CoursesRemoteDataSource,
    private val courseResponseToDomain: CourseResponseToDomain
) : CoursesRemoteRepository {

    override suspend fun getAllCourses(): List<CourseModel> {
        return coursesRemoteDataSource.downloadCourses().map { course ->
            courseResponseToDomain(course)
        }
    }

}