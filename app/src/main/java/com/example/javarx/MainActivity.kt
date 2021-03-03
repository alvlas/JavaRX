package com.example.javarx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton = findViewById<TextView>(R.id.start_button)
        startButton.setOnClickListener {
            Log.i(TAG, "onCreate: " + "startButton is pushed")
        }
    }
}