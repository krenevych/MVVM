package com.example.mvvm

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d(TAG, "onCreate: activity = $this")

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.buttonStart.setOnClickListener {
            startTimer(20_000, 1_000)
            Log.d(TAG, "onCreate: Timer starts")
        }
    }

    private fun startTimer(start: Long, step: Long) {
        object : CountDownTimer(start, step) {

            @SuppressLint("SetTextI18n")
            override fun onTick(millisUntilFinished: Long) {
                binding.textViewTime.text = (millisUntilFinished / 1000).toInt().toString()
                Log.d(TAG, "onTick: $millisUntilFinished, activity = ${this@MainActivity}")
            }

            override fun onFinish() {
                binding.textViewTime.text = "Timer is over"
                Log.d(TAG, "onFinish: Timer is over")
            }
        }.start()
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d(TAG, "onDestroy: ")
    }

    companion object {
        val TAG = "XXXX"
    }
}