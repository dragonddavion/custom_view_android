package com.davion.github.customview.util

import com.davion.github.customview.R

fun getImageDetailScreen(screenType: Int) : Int {
    return when (screenType) {
        0 -> R.drawable.im_progress
        else -> R.drawable.ic_question_mark
    }
}

fun getActionNavigationFromType(screenType: Int) : Int {
    return when (screenType) {
        0 -> R.id.action_screenFragment_to_progressFragment
        else -> -1
    }
}