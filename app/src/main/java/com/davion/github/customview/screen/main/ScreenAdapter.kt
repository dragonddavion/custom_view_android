package com.davion.github.customview.screen.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.davion.github.customview.databinding.ItemScreenBinding
import com.davion.github.customview.util.diffutil.ScreenDiffUtil


class ScreenAdapter : ListAdapter<Screen, ScreenViewHolder>(ScreenDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScreenViewHolder {
        return ScreenViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ScreenViewHolder, position: Int) {
        val screen = getItem(position)
        holder.bind(screen)
    }
}

class ScreenViewHolder(private val binding: ItemScreenBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(screen: Screen) {
        binding.tvTitle

    }

    companion object {
        fun from(parent: ViewGroup) : ScreenViewHolder{
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemScreenBinding.inflate(inflater)
            return ScreenViewHolder(binding)
        }
    }
}