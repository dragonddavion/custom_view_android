package com.davion.github.customview.screen.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.davion.github.customview.databinding.ItemGoodBinding
import com.davion.github.customview.model.Good
import com.davion.github.customview.util.createGoods
import com.davion.github.customview.util.diffutil.ItemDiffUtil
import java.util.*
import kotlin.collections.ArrayList

class SearchAdapter(private val clickListener: ((Good) -> Unit)?) : ListAdapter<Good, SearchViewHolder>(ItemDiffUtil<Good>()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val good = getItem(position)
        holder.bind(good)
    }

    override fun submitList(list: List<Good>?) {
        super.submitList(list?.let {
            ArrayList(it)
        })
    }

    fun filter(query : CharSequence?) {
        val unfilteredList = createGoods()
        val list = mutableListOf<Good>()

        if(!query.isNullOrEmpty()) {
            list.addAll(unfilteredList.filter {
                it.name.toLowerCase(Locale.ROOT).contains(query.toString().toLowerCase(Locale.ROOT))
            })
        } else {
            list.addAll(unfilteredList)
        }
        submitList(list)
    }
}

class SearchViewHolder(private val binding: ItemGoodBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(good: Good) {
        binding.goodName.text = good.name
        binding.level.text = good.level.toString()
        binding.time.text = good.time
    }

    companion object {
        fun from(parent: ViewGroup) : SearchViewHolder{
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemGoodBinding.inflate(inflater, parent, false)
            return SearchViewHolder(binding)
        }
    }
}