package com.davion.github.customview.util

import android.content.res.Resources
import androidx.core.content.res.ResourcesCompat
import com.davion.github.customview.R

fun getImageDetailScreen(screenType: Int) : Int {
    return when (screenType) {
        1 -> R.drawable.progress_cir
        else -> R.drawable.ic_question_mark
    }
}