package com.example.mvvm

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
//    val viewModel = MyViewModel()  // DO NOT CREATE VIEWMODEL IN ACTIVITY

    val viewModel by viewModels<MyViewModel>()

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
        viewModel.startTimer(100_000, 1_000)
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d(TAG, "onDestroy: ")
    }

    companion object {
        val TAG = "XXXX"
    }
}