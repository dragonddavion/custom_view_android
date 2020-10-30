package com.davion.github.customview.screen.search

import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
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
            onQueryTextChange(searchView)

            onSearchViewClickListenner(searchView)
        }
    }

    private fun onQueryTextChange(searchView: SearchView) {
        searchView.queryHint = "Search"
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query.isNullOrEmpty()) {
                    return false
                }
                val navController: NavController = binding.navSearch.findNavController()
                if (navController.currentDestination?.id == R.id.mainSearchFragment) {
                    navController.navigate(
                        MainSearchFragmentDirections.actionMainSearchFragmentToResultSearchFragment(
                            query
                        )
                    )
                } else {
                    val navHostFragment: NavHostFragment =
                        this@SearchFragment.childFragmentManager.findFragmentById(
                            R.id.nav_search
                        ) as NavHostFragment
                    (navHostFragment.childFragmentManager.fragments[0] as ResultSearchFragment).queryNewString(
                        query
                    )
                }
                searchView.clearFocus()
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }
        })
    }

    private fun onSearchViewClickListenner(searchView: SearchView) {
        searchView.setOnClickListener {
            searchView.isIconified = false
        }

        searchView.setOnCloseListener {
            searchView.onActionViewCollapsed()
            val navController: NavController = binding.navSearch.findNavController()

            if (navController.currentDestination?.id == R.id.resultSearchFragment) {
                navController.navigateUp()
            }
            true
        }
    }
}