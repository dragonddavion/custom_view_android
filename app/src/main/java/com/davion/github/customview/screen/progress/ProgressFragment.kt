package com.davion.github.customview.screen.progress

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.davion.github.customview.MainActivity
import com.davion.github.customview.R
import com.davion.github.customview.core.viewBinding
import com.davion.github.customview.databinding.FragmentProgressBinding

class ProgressFragment : Fragment(R.layout.fragment_progress) {

    private val binding by viewBinding(FragmentProgressBinding::bind)

    private lateinit var timer: CountDownTimer

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupActionBar()

        initTimer()

        initButton()
    }

    private fun setupActionBar() {
        binding.toolbarLayout.topAppBar.title = "Progress"

        val navController = this.findNavController()
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.toolbarLayout.topAppBar.setupWithNavController(navController, appBarConfiguration)
    }

    private fun initTimer() {
        timer = object : CountDownTimer(20000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.progressLayout.progressBar.progress += 5
                binding.progressLayout.seekBar.progress += 5
                binding.progressLayout.progressCircle.progress += 5
                val progressText = binding.progressLayout.progressCircle.progress.toString() + "%"
                binding.progressLayout.textView2.text = progressText
            }

            override fun onFinish() {
                Log.d("Davion", "onFinish")
            }
        }

        timer.start()
    }

    private fun initButton() {
        binding.progressLayout.button.setOnClickListener {
            binding.progressLayout.progressBar.progress += 10
        }

        binding.progressLayout.buttonReset.setOnClickListener {
            binding.progressLayout.progressBar.progress = 0
            binding.progressLayout.seekBar.progress = 0
            binding.progressLayout.progressCircle.progress = 0
            timer.cancel()
            timer.start()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        timer.cancel()
    }
}