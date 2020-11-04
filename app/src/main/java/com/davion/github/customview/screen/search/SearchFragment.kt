package com.davion.github.customview.screen.search

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
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

        setupSearchView(binding.searchView)
    }

    private fun setupActionBar() {
        setupMenu()

        val navController = this.findNavController()
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.toolbarLayout.toolbar.setupWithNavController(navController, appBarConfiguration)
    }

    private fun setupMenu() {
        binding.toolbarLayout.toolbar.inflateMenu(R.menu.top_app_bar)
        val menu = binding.toolbarLayout.toolbar.menu
        val favoriteItem = menu.findItem(R.id.favorite)
        favoriteItem.isVisible = false
        val searchItem = menu.findItem(R.id.search)
        val searchView: SearchView = searchItem.actionView as SearchView

        val editText = searchView.findViewById<EditText>(androidx.appcompat.R.id.search_src_text)
        editText.setTextColor(ContextCompat.getColor(requireContext(), R.color.colorTextWhite))
        editText.setHintTextColor(ContextCompat.getColor(requireContext(), R.color.colorTextWhite))
        setupSearchView(searchView)
    }

    private fun setupSearchView(searchView: SearchView) {
        onQueryTextChange(searchView)
        onSearchViewClickListenner(searchView)
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