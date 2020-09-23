package com.davion.github.customview.util.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.davion.github.customview.screen.main.Screen

class ScreenDiffUtil : DiffUtil.ItemCallback<Screen>() {
    override fun areItemsTheSame(oldItem: Screen, newItem: Screen): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Screen, newItem: Screen): Boolean {
        return newItem == oldItem
    }
}