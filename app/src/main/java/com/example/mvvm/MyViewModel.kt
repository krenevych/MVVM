package com.example.mvvm

import android.annotation.SuppressLint
import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.mvvm.MainActivity.Companion.TAG

class MyViewModel : ViewModel() {

    init {
        Log.d(TAG, "MyViewModel created: ${this}")
    }

    fun startTimer(start: Long, step: Long) {
        object : CountDownTimer(start, step) {

            @SuppressLint("SetTextI18n")
            override fun onTick(millisUntilFinished: Long) {
//                activity.binding.textViewTime.text = (millisUntilFinished / 1000).toInt().toString()
                Log.d(TAG, "onTick: $millisUntilFinished")
            }

            override fun onFinish() {
//                activity.binding.textViewTime.text = "Timer is over"
                Log.d(TAG, "onFinish: Timer is over")
            }
        }.start()
    }
}