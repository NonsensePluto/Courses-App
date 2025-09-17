package com.example.coursesapp.data.mappers

import com.example.coursesapp.data.remote.models.CourseResponse
import com.example.coursesapp.domain.models.CourseModel

class CourseResponseToDomain {
    operator fun invoke(course: CourseResponse) = CourseModel(
        course.id,
        course.title,
        course.text,
        course.price,
        course.rate,
        course.startDate,
        course.hasLike,
        course.publishDate
    )
}