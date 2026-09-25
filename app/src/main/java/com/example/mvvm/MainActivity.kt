package com.example.mvvm

import android.os.Bundle
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

    override fun onStart() {
        super.onStart()

        Log.d(TAG, "onStart: $this")
    }

    override fun onStop() {
        super.onStop()

        Log.d(TAG, "onStop:  $this")
    }

    override fun onPause() {
        super.onPause()

        Log.d(TAG, "onPause: $this")
    }

    override fun onResume() {
        super.onResume()

        Log.d(TAG, "onResume: $this")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d(TAG, "onDestroy: $this")
    }



    private fun startTimer() {
        Log.d(TAG, "onCreate: Timer starts")

        // TODO: create code to start timer
    }

    companion object {
        val TAG = "XXXX"
    }
}