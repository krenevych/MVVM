package com.example.mvvm

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
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
//            viewModel.startThread()
            Log.d(TAG, "onCreate: Timer starts")
        }

        viewModel.timerLiveData.observe(this) { currentTime: Long ->
            binding.textViewTime.text = (currentTime / 1_000).toInt().toString()
        }

//        (viewModel.timerLiveData as MutableLiveData<Long>).value = 100_500_100
//        viewModel.timerLiveData.value = 90_000_000
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