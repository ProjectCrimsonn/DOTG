package com.example.dotg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
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
            performLogin()
//            val intent = Intent(this@login, landing::class.java)
//            startActivity(intent)
//            finish()

        }
    }

    private fun performLogin() {
        val email: EditText = findViewById(R.id.login_email)
        val password: EditText = findViewById(R.id.login_password)


        val emailInput = email.text.toString().trim { it <= ' ' }
        val passwordInput = password.text.toString().trim { it <= ' ' }

        when {
            TextUtils.isEmpty(email.text.toString().trim { it <= ' ' }) -> {
                Toast.makeText(
                    this,
                    "Enter Email to log in",
                    Toast.LENGTH_SHORT
                ).show()
            }

            TextUtils.isEmpty(password.text.toString().trim { it <= ' ' }) -> {
                Toast.makeText(
                    this,
                    "Enter Password to log in",
                    Toast.LENGTH_SHORT
                ).show()
            }

            else -> {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(emailInput, passwordInput)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(
                                this,
                                "Login successful.",
                                Toast.LENGTH_SHORT
                            ).show()
                            val intent = Intent(this, landing::class.java)

                            intent.flags =
                                Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            intent.putExtra("user_email", emailInput)
                            startActivity(intent)
                            finish()
                        }else{
                            Toast.makeText(
                                this,
                                task.exception!!.message.toString(),
                                Toast.LENGTH_SHORT
                            ).show()
                        }


                    }
            }
        }


    }
}
