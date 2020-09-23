package com.davion.github.customview.screen.main


import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.davion.github.customview.R
import com.davion.github.customview.core.viewBinding
import com.davion.github.customview.databinding.FragmentScreenBinding

val TAG: String = ScreenFragment::class.java.simpleName

class ScreenFragment : Fragment(R.layout.fragment_screen) {
    private val binding: FragmentScreenBinding by viewBinding(FragmentScreenBinding::bind)

    private val viewModel: ScreenViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "Davion onViewCreated")

        initRecyclerView()

        initScreenData()

        onClickButton()

        observerNavigation()
    }

    private fun initScreenData() {
        viewModel.initScreenData()
    }

    private fun initRecyclerView() {
        val adapter = ScreenAdapter()
        binding.screens.adapter = adapter

        viewModel.screens.observe(viewLifecycleOwner, {
            Log.d("Davion", "observer Data: $it")
            it?.let {
                adapter.submitList(it)
            }
        })

    }

    private fun observerNavigation() {
        viewModel.navigateProgress.observe(viewLifecycleOwner, {
            it?.let {
                Log.d(TAG, "Davion observer navigate to the progress screen")
                this.findNavController().navigate(R.id.action_screenFragment_to_progressFragment)
                viewModel.navigateToProgressCompleted()
            }
        })
    }

    private fun onClickButton() {
        binding.btNavigate.setOnClickListener {
            viewModel.navigateToProgress()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Davion onCreate")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Davion onDestroy")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "Davion onAttach")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "Davion onDestroyView")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "Davion onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}