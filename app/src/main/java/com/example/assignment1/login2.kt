package com.example.assignment1

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.TextView


// Login screen where user can either log in or go back to sign up
class login2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login2)

        // Handle status bar and navigation bar padding for proper UI
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Button to go back to signup screen
        val btnSignUp = findViewById<Button>(R.id.signupBtn2)
        btnSignUp.setOnClickListener {
            val intentSignup = Intent(this, signup::class.java)
            startActivity(intentSignup)
            finish()
        }

        // Receive username from signup activity
        val username = intent.getStringExtra("USERNAME_KEY") ?: ""
        val usernameTextView = findViewById<TextView>(R.id.usernameTextView)
        usernameTextView.text = username

        // Receive image Uri from signup activity
        val imageUriString = intent.getStringExtra("IMAGE_URI_KEY")
        if (imageUriString != null) {
            val imageUri = Uri.parse(imageUriString)
            val profileImageView = findViewById<ImageView>(R.id.profileImage)
            profileImageView.setImageURI(imageUri)  // Display the received image
        }

        val btnLogin3 = findViewById<Button>(R.id.btnLogin)

        btnLogin3.setOnClickListener {
            val intentHome = Intent(this, HomeScreen::class.java)
            startActivity(intentHome)
        }
    }

}
