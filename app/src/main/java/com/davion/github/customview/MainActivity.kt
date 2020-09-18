package com.davion.github.customview

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        grid_layout.columnCount = 8
        grid_layout.rowCount = 3

        val layoutInflater = layoutInflater

        for (i in 0..15) {
            val childView = layoutInflater.inflate(R.layout.item_grid_layout, grid_layout, false)
            grid_layout.addView(childView)
        }

        for (i in 0..25) {
            val childView = layoutInflater.inflate(R.layout.item_grid_layout, grid_layout, false)
            grid_layout.addView(childView)
        }

        val timer = object : CountDownTimer(20000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                Log.d("Davion", "ontick: $millisUntilFinished")
                progressBar.progress += 5
                seek_bar.progress += 5
                progress_circle.progress += 5
                val progressText = progress_circle.progress.toString() + "%"
                textView2.text = progressText
            }

            override fun onFinish() {
                Log.d("Davion", "onFinish")
            }
        }

        timer.start()

        button.setOnClickListener {
            progressBar.progress += 10
        }

        button_reset.setOnClickListener {
            progressBar.progress = 0
            seek_bar.progress = 0
            progress_circle.progress = 0
            timer.cancel()
            timer.start()
        }
    }
}