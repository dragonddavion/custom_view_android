package com.davion.github.customview.util.diffutil

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.davion.github.customview.model.BaseModel

class  ItemDiffUtil <T: BaseModel>: DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return newItem == oldItem
    }
}