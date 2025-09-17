package com.example.coursesapp.presentation.mainscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coursesapp.domain.models.CourseModel
import com.example.coursesapp.domain.usecases.GetAllCoursesUseCase
import kotlinx.coroutines.launch

class MainScreenViewModel(private val getAllCoursesUseCase: GetAllCoursesUseCase) : ViewModel() {

    private val _courses = MutableLiveData<List<CourseModel>>()
    val courses: LiveData<List<CourseModel>> = _courses

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    init {
        viewModelScope.launch {
            getAllCourses()
        }
    }

    fun getAllCourses() {
        viewModelScope.launch {
            _loading.value = true
            _courses.value = getAllCoursesUseCase()
            _loading.value = false
        }
    }
}