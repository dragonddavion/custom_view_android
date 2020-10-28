package com.davion.github.customview.screen.search

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.davion.github.customview.databinding.ItemGoodBinding
import com.davion.github.customview.model.Good
import com.davion.github.customview.util.diffutil.ItemDiffUtil

class SearchAdapter(private val clickListener: ((Good) -> Unit)?) : ListAdapter<Good, SearchViewModel>(
    ItemDiffUtil<Good>()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewModel {
        return SearchViewModel.from(parent)
    }

    override fun onBindViewHolder(holder: SearchViewModel, position: Int) {
        val good = getItem(position)
        holder.bind(good)
    }

    override fun submitList(list: List<Good>?) {
        Log.d("Davion", "submit list $list")
        super.submitList(list?.let {
            ArrayList(it)
        })
    }
}

class SearchViewModel(private val binding: ItemGoodBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(good: Good) {
        binding.goodName.text = good.name
        binding.level.text = good.level.toString()
        binding.time.text = good.time
    }

    companion object {
        fun from(parent: ViewGroup) : SearchViewModel{
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemGoodBinding.inflate(inflater, parent, false)
            return SearchViewModel(binding)
        }
    }
}