package com.davion.github.customview.screen.collapsing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.davion.github.customview.R
import com.davion.github.customview.core.viewBinding
import com.davion.github.customview.databinding.FragmentCollapsingBinding

class CollapsingFragment : Fragment(R.layout.fragment_collapsing) {
    private val binding: FragmentCollapsingBinding by viewBinding(FragmentCollapsingBinding::bind)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.collapsingToolbarLayout.title = "Collapsing Toolbar"
    }
}