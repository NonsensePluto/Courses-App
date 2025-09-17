package com.example.coursesapp.presentation.mainscreen.utils

import com.example.coursesapp.domain.models.CourseModel
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class CoursesAdapter(
    onDetailsClick: (CourseModel) -> Unit,
    onFavoriteClick: (CourseModel) -> Unit
) : ListDelegationAdapter<List<CourseModel>>() {

    init {
        delegatesManager.addDelegate(courseAdapterDelegate(onDetailsClick, onFavoriteClick))
    }
}