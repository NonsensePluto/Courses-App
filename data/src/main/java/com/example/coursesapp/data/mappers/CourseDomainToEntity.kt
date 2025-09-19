package com.example.coursesapp.data.mappers

import com.example.coursesapp.data.local.entities.CourseEntity
import com.example.coursesapp.domain.models.CourseModel

class CourseDomainToEntity {
    operator fun invoke(course: CourseModel) = CourseEntity(
        id = course.id,
        title = course.title,
        text = course.text,
        price =course.price,
        rate =course.rate,
        startDate = course.startDate,
        hasLike = course.hasLike,
        publishDate =course.publishDate,
        imageUrl = course.imageUrl
    )
}