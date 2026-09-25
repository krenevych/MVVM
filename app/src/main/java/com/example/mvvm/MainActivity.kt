package com.example.mvvm

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import com.example.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d(TAG, "onCreate: $this")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            startTimer()
        }

    }


    private fun startTimer() {
        Log.d(TAG, "onCreate: Timer starts")

        object : CountDownTimer(20_000, 1_000){
            override fun onTick(millisUntilFinished: Long) {
                Log.d(TAG, "onTick: $millisUntilFinished")
                val secondsLeft = millisUntilFinished / 1000
                binding.tvTimer.text = secondsLeft.toString()
            }

            override fun onFinish() {
                Log.d(TAG, "onFinish: Timer is over!")
                binding.tvTimer.text = "Timer is over!"
            }

        }.start()
    }

    companion object {
        val TAG = "XXXX"
    }
}