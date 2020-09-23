package com.davion.github.customview.screen.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScreenViewModel : ViewModel() {

    private val _navigateProgress: MutableLiveData<Boolean> = MutableLiveData()
    val navigateProgress: LiveData<Boolean>
        get() = _navigateProgress





    fun navigateToProgress() {
        _navigateProgress.value = true
    }

    fun navigateToProgressCompleted() {
        _navigateProgress.value = null
    }
}