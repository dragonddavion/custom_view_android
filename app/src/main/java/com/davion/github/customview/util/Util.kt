package com.davion.github.customview.util

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
    goods.add(Good(name = "White", level = 1, time = "2 min"))
    goods.add(Good(name = "Egg", level = 1, time = "20 min"))
    goods.add(Good(name = "Corn", level = 2, time = "5 min"))
    goods.add(Good(name = "Bread", level = 2, time = "4 min"))
    goods.add(Good(name = "Chicken feed", level = 3, time = "4 min"))
    goods.add(Good(name = "Soybean", level = 5, time = "20 min"))
    goods.add(Good(name = "Cow feed", level = 6, time = "8 min"))
    goods.add(Good(name = "Milk", level = 6, time = "1 hour"))
    goods.add(Good(name = "Cream", level = 6, time = "17 min"))
    goods.add(Good(name = "Sugarcane", level = 7, time = "30 min"))
    goods.add(Good(name = "Brown sugar", level = 7, time = "17 min"))
    goods.add(Good(name = "Popcorn", level = 8, time = "25 min"))
    goods.add(Good(name = "Carrot", level = 9, time = "10 min"))
    goods.add(Good(name = "Butter", level = 9, time = "25 min"))
    goods.add(Good(name = "Pancake", level = 9, time = "25 min"))
    goods.add(Good(name = "Pig feed", level = 10, time = "17 min"))
    goods.add(Good(name = "Bacon", level = 10, time = "4 hour"))
    goods.add(Good(name = "Cookie", level = 10, time = "1 hour 51 min"))
    return goods
}