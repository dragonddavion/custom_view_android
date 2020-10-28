package com.davion.github.customview.screen.search

import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.davion.github.customview.R
import com.davion.github.customview.core.viewBinding
import com.davion.github.customview.databinding.FragmentSearchBinding

class SearchFragment : Fragment(R.layout.fragment_search) {
    private val binding: FragmentSearchBinding by viewBinding(FragmentSearchBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupActionBar()

        setupSearchView()
    }

    private fun setupActionBar() {
        val navController = this.findNavController()
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.toolbar.topAppBar.setupWithNavController(navController, appBarConfiguration)
    }

    private fun setupSearchView() {
        binding.searchView.also { searchView ->
            searchView.queryHint = "Search"

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(p0: String?): Boolean {
                    val navController = binding.navSearch.findNavController()
                    navController.navigate(R.id.action_mainSearchFragment_to_resultSearchFragment)
                    return true
                }
                override fun onQueryTextChange(p0: String?): Boolean {
                    return false
                }
            })

            searchView.setOnClickListener {
                searchView.isIconified = false
            }
        }
    }
}