package com.davion.github.customview.screen.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScreenViewModel : ViewModel() {

    private val screenList: MutableList<Screen> = mutableListOf()
    private val _screens: MutableLiveData<List<Screen>> = MutableLiveData()
    val screens: LiveData<List<Screen>>
        get() = _screens

    private val _navigateProgress: MutableLiveData<Boolean> = MutableLiveData()
    val navigateProgress: LiveData<Boolean>
        get() = _navigateProgress




    fun navigateToProgress() {
        _navigateProgress.value = true
    }

    fun navigateToProgressCompleted() {
        _navigateProgress.value = null
    }

    fun initScreenData() {
        val progressScreen = Screen(0, "Progress", "The view is progress")
        screenList.add(progressScreen)
        _screens.value = screenList
    }
}