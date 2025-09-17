package com.example.coursesapp.data.remote.models

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("courses")
    val courses: List<CourseResponse>
)