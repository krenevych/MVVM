package com.example.mvvm

import android.annotation.SuppressLint
import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.MainActivity.Companion.TAG
import kotlin.concurrent.thread

class MyViewModel : ViewModel() {

    init {
        Log.d(TAG, "MyViewModel created: ${this}")
    }

    private val _timerLiveData: MutableLiveData<Long> = MutableLiveData(0)
    val timerLiveData: LiveData<Long>
        get() = _timerLiveData

    fun startTimer(start: Long, step: Long) {
        object : CountDownTimer(start, step) {

            @SuppressLint("SetTextI18n")
            override fun onTick(millisUntilFinished: Long) {
                _timerLiveData.value = millisUntilFinished
//                timerLiveData.postValue(millisUntilFinished)
                Log.d(TAG, "onTick: $millisUntilFinished")
            }

            override fun onFinish() {
                Log.d(TAG, "onFinish: Timer is over")
            }
        }.start()
    }

    fun startThread(){
        thread {
            Thread.sleep(3_000)
            _timerLiveData.postValue(10_000_000)  // we use postValue from background thread
//            _timerLiveData.value = 100_000_000  // we cant use setValue from background thread
        }
    }
}