package com.example.coursesapp.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "course_table")
data class CourseEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val text: String,
    val price: String,
    val rate: Double,
    val startDate: String,
    var hasLike: Boolean,
    val publishDate: String,
    val imageUrl: String?
)
