package com.davion.github.customview.util

import com.davion.github.customview.R

fun getImageDetailScreen(screenType: Int) : Int {
    return when (screenType) {
        0 -> R.drawable.im_progress
        else -> R.drawable.im_question_mark
    }
}

fun getActionNavigationFromType(screenType: Int) : Int {
    return when (screenType) {
        0 -> R.id.action_screenFragment_to_progressFragment
        1 -> R.id.action_screenFragment_to_collapsingFragment
        2 -> R.id.action_screenFragment_to_searchFragment
        else -> -1
    }
}