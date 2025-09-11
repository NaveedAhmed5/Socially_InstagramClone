package com.example.assignment1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSignUp = findViewById<Button>(R.id.signupBtn)

        btnSignUp.setOnClickListener {
            val intentSignup = Intent(this, signup::class.java)
            startActivity(intentSignup)
        }



        val btnLogin = findViewById<Button>(R.id.btnLogin2)

        btnLogin.setOnClickListener {
            val usernameEditText: EditText = findViewById(R.id.emailTextBox)
            val username = usernameEditText.text.toString().trim()
            val intentLogin = Intent(this, login2::class.java)
            intentLogin.putExtra("USERNAME_KEY", username)
            startActivity(intentLogin)
        }


    }
}