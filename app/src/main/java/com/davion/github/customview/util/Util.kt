package com.davion.github.customview.util

import android.view.View
import android.view.inputmethod.InputMethodManager
import com.davion.github.customview.R
import com.davion.github.customview.model.Good

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

fun createGoods() : List<Good> {
    val goods = mutableListOf<Good>()
    goods.add(Good(id = 1, name = "White", level = 1, time = "2 min"))
    goods.add(Good(id = 2, name = "Egg", level = 1, time = "20 min"))
    goods.add(Good(id = 3, name = "Corn", level = 2, time = "5 min"))
    goods.add(Good(id = 4, name = "Bread", level = 2, time = "4 min"))
    goods.add(Good(id = 5, name = "Chicken feed", level = 3, time = "4 min"))
    goods.add(Good(id = 6, name = "Soybean", level = 5, time = "20 min"))
    goods.add(Good(id = 7, name = "Cow feed", level = 6, time = "8 min"))
    goods.add(Good(id = 8, name = "Milk", level = 6, time = "1 hour"))
    goods.add(Good(id = 9, name = "Cream", level = 6, time = "17 min"))
    goods.add(Good(id = 10, name = "Sugarcane", level = 7, time = "30 min"))
    goods.add(Good(id = 11, name = "Brown sugar", level = 7, time = "17 min"))
    goods.add(Good(id = 12, name = "Popcorn", level = 8, time = "25 min"))
    goods.add(Good(id = 13, name = "Carrot", level = 9, time = "10 min"))
    goods.add(Good(id = 14, name = "Butter", level = 9, time = "25 min"))
    goods.add(Good(id = 15, name = "Pancake", level = 9, time = "25 min"))
    goods.add(Good(id = 16, name = "Pig feed", level = 10, time = "17 min"))
    goods.add(Good(id = 17, name = "Bacon", level = 10, time = "4 hour"))
    goods.add(Good(id = 18, name = "Cookie", level = 10, time = "1 hour 51 min"))
    return goods
}

fun View.hideKeyboard() {
    val inputMethodManager = context!!.getSystemService(android.content.Context.INPUT_METHOD_SERVICE) as? InputMethodManager
    inputMethodManager?.hideSoftInputFromWindow(this.windowToken, 0)
}