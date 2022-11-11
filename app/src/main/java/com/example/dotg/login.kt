package com.example.dotg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class login : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = Firebase.auth
        var signUpLink = findViewById<Button>(R.id.sign_up_link)
        signUpLink.setOnClickListener {
            val intent = Intent(this@login, register::class.java)
            startActivity(intent)
            finish()
        }
        val loginButton: Button = findViewById(R.id.login_button)
        loginButton.setOnClickListener {
//            performLogin()
            val intent = Intent(this@login, landing::class.java)
            startActivity(intent)
            finish()

        }
    }
    private fun performLogin() {
        val email: EditText = findViewById(R.id.login_email)
        val password: EditText = findViewById(R.id.login_password)

        if (email.text.isEmpty() || password.text.isEmpty()) {
            Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT)
                .show()
            return
        }
        val emailInput = email.text.toString()
        val passwordInput = password.text.toString()

        auth.createUserWithEmailAndPassword(emailInput, passwordInput)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success
                    // If sign in fails, display a message to the user.
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)

                    Toast.makeText(
                        baseContext, "Success.",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            .addOnFailureListener {
                Toast.makeText(this, "Error occured ${it.localizedMessage}",
                    Toast.LENGTH_SHORT)
                    .show()
            }

    }
}
