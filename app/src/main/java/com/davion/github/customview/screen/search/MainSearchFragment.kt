package com.davion.github.customview.screen.search

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.davion.github.customview.R
import com.davion.github.customview.core.viewBinding
import com.davion.github.customview.databinding.FragmentMainSearchBinding
import com.davion.github.customview.util.createGoods

class MainSearchFragment : Fragment(R.layout.fragment_main_search) {
    private val binding: FragmentMainSearchBinding by viewBinding(FragmentMainSearchBinding::bind)
    private val searchAdapter: SearchAdapter by lazy {
        SearchAdapter(null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.goodList.apply {
            layoutManager = LinearLayoutManager(this@MainSearchFragment.requireContext())
            this.adapter = searchAdapter
            isNestedScrollingEnabled = false
        }
        searchAdapter.submitList(createGoods())
    }
}