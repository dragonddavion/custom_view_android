package com.davion.github.customview

import android.os.Bundle
import android.view.MotionEvent
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import com.davion.github.customview.util.hideKeyboard

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        handleDispatch(event)
        return super.dispatchTouchEvent(event)
    }

    private fun handleDispatch(event: MotionEvent?){
        if (event?.action == MotionEvent.ACTION_UP) {
            val view = currentFocus
            if (view is AppCompatEditText || view is EditText) {
                val scrcoords = IntArray(2)
                view.getLocationOnScreen(scrcoords)
                val x = event.rawX
                val y = event.rawY
                // if we touch outside a focused edittext, hide the keyboard
                if (x < scrcoords[0] || x >= scrcoords[0] + view.measuredWidth
                    || y < scrcoords[1] || y > scrcoords[1] + view.measuredHeight
                ) {
                    view.clearFocus()
                    view.hideKeyboard()
                }
            }
        }
    }
}