package com.davion.github.customview.screen.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.davion.github.customview.R
import com.davion.github.customview.core.viewBinding
import com.davion.github.customview.databinding.FragmentMainSearchBinding

class MainSearchFragment : Fragment(R.layout.fragment_main_search) {
    val binding: FragmentMainSearchBinding by viewBinding(FragmentMainSearchBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}