package com.example.dotg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class register : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = Firebase.auth

        var loginLink = findViewById<Button>(R.id.log_in_link)
        loginLink.setOnClickListener {
            val intent = Intent(this@register, login::class.java)
            startActivity(intent)
            finish()
        }
        val registerbutton: Button = findViewById(R.id.login_button)

        registerbutton.setOnClickListener {
            performSignUp()
        }

    }

    private fun performSignUp() {
        val email = findViewById<EditText>(R.id.login_email)
        val password = findViewById<EditText>(R.id.login_password)
        val password_2 = findViewById<EditText>(R.id.confirm_password)

        val inputEmail = email.text.toString().trim { it <= ' ' }
        val inputPassword = password.text.toString().trim { it <= ' ' }
        val confirm_pass = password_2.text.toString().trim { it <= ' ' }

        when {
            !TextUtils.equals(inputPassword, confirm_pass) -> {
                Toast.makeText(
                    this,
                    "Passwords do not match!",
                    Toast.LENGTH_SHORT
                ).show()
            }
            TextUtils.isEmpty(inputEmail) -> {
                Toast.makeText(
                    this,
                    "Enter Email",
                    Toast.LENGTH_SHORT
                ).show()
            }
            TextUtils.isEmpty(inputPassword) -> {
                Toast.makeText(
                    this,
                    "Enter a Password.",
                    Toast.LENGTH_SHORT
                ).show()
            }

            else -> {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(inputEmail, inputPassword)
                    .addOnCompleteListener(
                        OnCompleteListener<AuthResult> { task ->
                            if (task.isSuccessful) {
                                val firebaseUser: FirebaseUser = task.result!!.user!!
                                Toast.makeText(
                                    this,
                                    "Registration successful.",
                                    Toast.LENGTH_SHORT
                                ).show()
                                val intent =
                                    Intent(this, landing::class.java)
                                intent.flags =
                                    Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                intent.putExtra("user_id", firebaseUser.uid)
                                intent.putExtra("user_email", inputEmail)
                                startActivity(intent)
                                finish()
                            } else {
                                Toast.makeText(
                                    this,
                                    task.exception!!.message.toString(),
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    )
            }
        }
    }


}