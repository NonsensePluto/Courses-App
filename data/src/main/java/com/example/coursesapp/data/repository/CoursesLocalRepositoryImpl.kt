package com.example.coursesapp.data.repository

import com.example.coursesapp.data.local.dao.CourseDao
import com.example.coursesapp.data.mappers.CourseDomainToEntity
import com.example.coursesapp.data.mappers.CourseEntityToDomain
import com.example.coursesapp.domain.models.CourseModel
import com.example.coursesapp.domain.repository.CoursesLocalRepository

class CoursesLocalRepositoryImpl(
    private val dao: CourseDao,
    private val coursesEntityToDomain: CourseEntityToDomain,
    private val coursesDomainToEntity: CourseDomainToEntity
) : CoursesLocalRepository {

    override suspend fun toggleCourseSaved(course: CourseModel) {
        val mappedCourse = coursesDomainToEntity(course)
        if (dao.isCourseSaved(mappedCourse.id)) {
            dao.deleteCourse(mappedCourse)
        } else {
            dao.insertCourse(mappedCourse)
        }
    }

}