package com.example.cs338_midterm

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.cs338_midterm.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    private var count = 0
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("count", 0)
            binding.counterTextView.text = count.toString()
        }

        // Increase button
        binding.increaseButton.setOnClickListener {
            val increment = binding.incrementEditText.text.toString().toIntOrNull() ?: 1
            count += increment
            binding.counterTextView.text = count.toString()
        }

        // Reset button
        binding.resetButton.setOnClickListener {
            count = 0
            binding.counterTextView.text = count.toString()
        }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count", count)
    }



}