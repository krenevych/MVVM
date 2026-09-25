package com.example.mvvm

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.MainActivity.Companion.TAG

class TimerViewModel : ViewModel()  {

    init {
        Log.d(TAG, "TimerViewModel created: ")
    }

    private val _timerLiveData = MutableLiveData<Long>(0)
    val timerLiveData: LiveData<Long>
        get() = _timerLiveData


    fun startTimer() {
        Log.d(TAG, "onCreate: Timer starts")

        object : CountDownTimer(20_000, 1_000){
            override fun onTick(milliSeconds: Long) {
                Log.d(TAG, "onTick: $milliSeconds")
                _timerLiveData.value = milliSeconds
//                val secondsLeft = millisUntilFinished / 1000
//                activity.binding.tvTimer.text = secondsLeft.toString()
            }

            override fun onFinish() {
                Log.d(TAG, "onFinish: Timer is over!")
                _timerLiveData.value = -100500
//                activity.binding.tvTimer.text = "Timer is over!"
            }

        }.start()
    }

    override fun onCleared() {
        super.onCleared()

        Log.d(TAG, "TimerViewModel Cleared: ")

    }

}