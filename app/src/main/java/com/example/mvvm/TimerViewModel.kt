package com.example.mvvm

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.mvvm.MainActivity.Companion.TAG

class TimerViewModel : ViewModel()  {

    init {
        Log.d(TAG, "TimerViewModel created: ")
    }

    fun startTimer(activity: MainActivity) {
        Log.d(TAG, "onCreate: Timer starts")

        object : CountDownTimer(20_000, 1_000){
            override fun onTick(millisUntilFinished: Long) {
                Log.d(TAG, "onTick: $millisUntilFinished")
                val secondsLeft = millisUntilFinished / 1000
                activity.binding.tvTimer.text = secondsLeft.toString()
            }

            override fun onFinish() {
                Log.d(TAG, "onFinish: Timer is over!")
                activity.binding.tvTimer.text = "Timer is over!"
            }

        }.start()
    }

    override fun onCleared() {
        super.onCleared()

        Log.d(TAG, "TimerViewModel Cleared: ")

    }

}