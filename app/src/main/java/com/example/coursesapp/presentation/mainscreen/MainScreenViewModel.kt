package com.example.coursesapp.presentation.mainscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coursesapp.domain.models.CourseModel
import com.example.coursesapp.domain.usecases.GetAllCoursesUseCase
import com.example.coursesapp.domain.usecases.GetSavedCoursesUseCase
import com.example.coursesapp.domain.usecases.InsertCourseUseCase
import com.example.coursesapp.domain.usecases.IsCourseSavedUseCase
import com.example.coursesapp.domain.usecases.ToggleCourseSavedUseCase
import kotlinx.coroutines.launch

class MainScreenViewModel(
    private val getAllCoursesUseCase: GetAllCoursesUseCase,
    private val insertCourseUseCase: InsertCourseUseCase,
    private val toggleSavedCourseUseCase: ToggleCourseSavedUseCase,
    private val getSavedCoursesUseCase: GetSavedCoursesUseCase
) : ViewModel() {

    private val _courses = MutableLiveData<List<CourseModel>>()
    val courses: LiveData<List<CourseModel>> = _courses

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    init {
        viewModelScope.launch {
            loadAndMergeCourses()
        }
    }

    fun loadAndMergeCourses() {
        viewModelScope.launch {
            _loading.value = true
            val allCourses = getAllCoursesUseCase()
            val savedCourses = getSavedCoursesUseCase()
            val mergedCourses = allCourses.map { course ->
                course.copy(hasLike = savedCourses.any { it.id == course.id })
            }
            _courses.value = mergedCourses

            val toInsert = mergedCourses.filter { it.hasLike && !savedCourses.contains(it) }
            if (toInsert.isNotEmpty()) {
                toInsert.forEach { insertCourseUseCase(it) }
            }
        }
    }

    fun toggleSavedCourse(course: CourseModel) {
        viewModelScope.launch {
            val updatedList = _courses.value!!.map {
                if (it.id == course.id) it.copy(hasLike = !it.hasLike) else it
            }
            _courses.value = updatedList
            toggleSavedCourseUseCase(course)
        }
    }

    fun sortCoursesByDate() {
        _courses.value = _courses.value?.sortedByDescending { it.publishDate }
    }
}