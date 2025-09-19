package com.example.coursesapp.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.coursesapp.data.local.entities.CourseEntity

@Dao
interface CourseDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCourse(course: CourseEntity)

    @Delete
    suspend fun deleteCourse(course: CourseEntity)

    @Query("SELECT EXISTS(SELECT * FROM course_table WHERE id = :courseId)")
    suspend fun isCourseSaved(courseId: Int): Boolean
}