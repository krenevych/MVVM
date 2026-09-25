package com.example.mvvm

import android.os.Bundle
import android.os.CountDownTimer
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

        binding.btnStart.setOnClickListener {
            startTimer()
        }

    }

    private fun startTimer() {
        viewModel.startTimer(this)
    }

    companion object {
        val TAG = "XXXX"
    }
}