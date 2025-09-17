package com.example.coursesapp.data.remote.api

import com.example.coursesapp.data.remote.models.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CoursesApi {

    @GET("uc")
    suspend fun downloadCoursesJson(
        @Query("id") id: String = "15arTK7XT2b7Yv4BJsmDctA4Hg-BbS8-q",
        @Query("export") export: String = "download"
    ): ApiResponse
}
