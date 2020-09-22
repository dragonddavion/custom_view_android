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
import com.davion.github.customview.databinding.FragmentMainBinding

val TAG: String = MainFragment::class.java.simpleName

class MainFragment : Fragment(R.layout.fragment_main) {
    private val binding by viewBinding(FragmentMainBinding::bind)

    private val viewModel: MainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "Davion onViewCreated")

        binding.btNavigate.setOnClickListener {
            viewModel.navigateToProgress()
        }

        viewModel.navigateProgress.observe(viewLifecycleOwner,  {
            it?.let {
                Log.d(TAG, "Davion observer navigate to the progress screen")
                this.findNavController().navigate(R.id.action_mainFragment_to_progressFragment)
                viewModel.navigateToProgressCompleted()
            }
        })
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