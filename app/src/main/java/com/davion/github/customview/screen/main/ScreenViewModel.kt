package com.davion.github.customview.screen.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScreenViewModel : ViewModel() {

    private val screenList: MutableList<Screen> = mutableListOf()
    private val _screens: MutableLiveData<List<Screen>> = MutableLiveData()
    val screens: LiveData<List<Screen>>
        get() = _screens

    private val _screenNavigation: MutableLiveData<Int> = MutableLiveData()
    val screenNavigation: LiveData<Int>
        get() = _screenNavigation

    init {
        initScreenData()
    }


    fun navigateToScreen(screenType: Int) {
        _screenNavigation.value = screenType
    }

    fun navigateToScreenCompleted() {
        _screenNavigation.value = null
    }

    private fun initScreenData() {
        val progressScreen = Screen(0, "Progress", "The view is progress")
        screenList.add(progressScreen)
        _screens.value = screenList
    }
}