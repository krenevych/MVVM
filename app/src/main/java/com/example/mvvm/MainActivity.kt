package com.example.mvvm

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // TODO: make binding private
    lateinit var binding: ActivityMainBinding

    // FIXME: create viewModel in correct way!!!
//    private val viewModel = TimerViewModel()
    private val viewModel by viewModels<TimerViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d(TAG, "onCreate: $this")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.timerLiveData.observe(this) { milliSeconds: Long ->
            if (milliSeconds == -100500L){
                binding.tvTimer.text = "Timer is over!"
            } else {
                val secondsLeft = milliSeconds / 1_000L
                binding.tvTimer.text = secondsLeft.toString()
            }
        }

        binding.btnStart.setOnClickListener {
            startTimer()
        }

    }

    private fun startTimer() {
        viewModel.startTimer()
    }

    companion object {
        val TAG = "XXXX"
    }
}