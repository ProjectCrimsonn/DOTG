package com.example.dotg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var loginLink = findViewById<Button>(R.id.log_in_link)
        loginLink.setOnClickListener{
            val intent = Intent(this@register, login::class.java)
            startActivity(intent)
            finish()
        }

    }
}