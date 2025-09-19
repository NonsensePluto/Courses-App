package com.example.coursesapp.data.local.appdatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.coursesapp.data.local.dao.CourseDao
import com.example.coursesapp.data.local.entities.CourseEntity


@Database(
    entities = [CourseEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun courseDao(): CourseDao
}