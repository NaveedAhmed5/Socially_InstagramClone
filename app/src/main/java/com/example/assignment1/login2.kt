package com.example.assignment1

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.appbar.MaterialToolbar
import android.widget.EditText
import android.widget.TextView
import java.util.*

class login2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login2)


        val btnSignUp = findViewById<Button>(R.id.signupBtn2)

        btnSignUp.setOnClickListener {
            val intentSignup = Intent(this, signup::class.java)
            startActivity(intentSignup)
        }

        val username = intent.getStringExtra("USERNAME_KEY")
        findViewById<TextView>(R.id.usernameTextView).text = username
    }
}