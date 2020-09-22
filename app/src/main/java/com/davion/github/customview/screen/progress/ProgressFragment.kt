package com.davion.github.customview.screen.progress

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.davion.github.customview.R
import com.davion.github.customview.core.viewBinding
import com.davion.github.customview.databinding.FragmentProgressBinding
import kotlinx.android.synthetic.main.fragment_progress.*

class ProgressFragment : Fragment(R.layout.fragment_progress) {

    private val binding by viewBinding(FragmentProgressBinding::bind)

    private lateinit var timer: CountDownTimer

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.gridLayout.columnCount = 8
        binding.gridLayout.rowCount = 3

        val layoutInflater = layoutInflater

        for (i in 0..15) {
            val childView = layoutInflater.inflate(R.layout.item_grid_layout, binding.gridLayout, false)
            binding.gridLayout.addView(childView)
        }

        for (i in 0..25) {
            val childView = layoutInflater.inflate(R.layout.item_grid_layout, binding.gridLayout, false)
            binding.gridLayout.addView(childView)
        }

        timer = object : CountDownTimer(20000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.progressBar.progress += 5
                binding.seekBar.progress += 5
                binding.progressCircle.progress += 5
                val progressText = binding.progressCircle.progress.toString() + "%"
                binding.textView2.text = progressText
            }

            override fun onFinish() {
                Log.d("Davion", "onFinish")
            }
        }

        timer.start()

        binding.button.setOnClickListener {
            binding.progressBar.progress += 10
        }

        button_reset.setOnClickListener {
            binding.progressBar.progress = 0
            binding.seekBar.progress = 0
            binding.progressCircle.progress = 0
            timer.cancel()
            timer.start()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        timer.cancel()
    }
}