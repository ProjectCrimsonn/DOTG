package com.example.dotg

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.example.dotg.databinding.ActivityPlannedBinding

class planned : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPlannedBinding.inflate(layoutInflater)
        val view = binding.root

        binding.backButton.setOnClickListener {
            finish()
        }

        binding.bookBtn.setOnClickListener {
            Toast.makeText(this, "AWAITING CONFIRMATION", Toast.LENGTH_SHORT).show()
        }

        setContentView(view)

    }
}