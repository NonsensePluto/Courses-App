package com.example.coursesapp.presentation.mainscreen.utils

import android.widget.TextView
import com.example.coursesapp.R
import com.example.coursesapp.domain.models.CourseModel
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.example.coursesapp.databinding.CourseCardBinding

fun courseAdapterDelegate(
    onDetailsClick: (CourseModel) -> Unit,
    onFavoriteClick: (CourseModel) -> Unit
) = adapterDelegateViewBinding<CourseModel, CourseModel, CourseCardBinding>(
    { inflater, parent -> CourseCardBinding.inflate(inflater, parent, false) }
) {

    bind {
        binding.apply {
            tvTitle.text = item.title
            tvDescription.text = item.text
            tvPrice.text = item.price
            tvDate.text = item.publishDate

            (tvRating.getChildAt(1) as? TextView)?.text = item.rate.toString()

            // картинка (пока у CourseModel её нет → можно добавить поле imageUrl в domain, если планируется)
//            ivCourseImage.setImageResource(com.example.coursesapp.R.drawable.)

            // избранное
            ibFavorite.setImageResource(
                if (item.hasLike) R.drawable.ic_save_filled else R.drawable.ic_save
            )

            // клики
            btnDetails.setOnClickListener { onDetailsClick(item) }
            ibFavorite.setOnClickListener { onFavoriteClick(item) }
        }
    }
}