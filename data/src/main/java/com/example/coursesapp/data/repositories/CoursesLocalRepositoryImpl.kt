package com.example.coursesapp.data.repositories

import com.example.coursesapp.data.local.dao.CourseDao
import com.example.coursesapp.data.mappers.CourseDomainToEntity
import com.example.coursesapp.data.mappers.CourseEntityToDomain
import com.example.coursesapp.domain.models.CourseModel
import com.example.coursesapp.domain.repositories.CoursesLocalRepository

class CoursesLocalRepositoryImpl(
    private val dao: CourseDao,
    private val coursesDomainToEntity: CourseDomainToEntity,
    private val coursesEntityToDomain: CourseEntityToDomain,
) : CoursesLocalRepository {

    override suspend fun toggleCourseSaved(course: CourseModel) {
        val mappedCourse = coursesDomainToEntity(course)
        if (dao.isCourseSaved(mappedCourse.id)) {
            dao.deleteCourse(mappedCourse)
        } else {
            dao.insertCourse(mappedCourse)
        }
    }

    override suspend fun insertCourse(course: CourseModel) {
        val mappedCourse = coursesDomainToEntity(course)
        dao.insertCourse(mappedCourse)
    }

    override suspend fun isCourseSaved(courseId: Int): Boolean {
        return dao.isCourseSaved(courseId)
    }

    override suspend fun getSavedCourses(): List<CourseModel> {
        return dao.getSavedCourses().map { coursesEntityToDomain(it) }
    }

}