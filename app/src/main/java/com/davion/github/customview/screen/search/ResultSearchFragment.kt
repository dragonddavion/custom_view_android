package com.davion.github.customview.screen.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.davion.github.customview.R
import com.davion.github.customview.core.viewBinding
import com.davion.github.customview.databinding.FragmentResultSearchBinding

class ResultSearchFragment : Fragment(R.layout.fragment_result_search) {
    private val binding by viewBinding(FragmentResultSearchBinding::bind)
    private val args: ResultSearchFragmentArgs by navArgs()
    private val searchAdapter: SearchAdapter by lazy {
        SearchAdapter(null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.goodList.apply {
            layoutManager = LinearLayoutManager(this@ResultSearchFragment.requireContext())
            this.adapter = searchAdapter
        }
        searchAdapter.filter(args.query)
    }

    fun queryNewString(query: String) {
        searchAdapter.filter(query)
    }
}
