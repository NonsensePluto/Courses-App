package com.example.coursesapp.domain.models

data class CourseModel(
    val id: Int,
    val title: String,
    val text: String,
    val price: String,
    val rate: Double,
    val startDate: String,
    var hasLike: Boolean,
    val publishDate: String
)