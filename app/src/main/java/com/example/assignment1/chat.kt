package com.example.assignment1

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent

class chat : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_chat)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Retrieve and set the username to the TextView
        val personName = intent.getStringExtra("PersonName")
        val personNameTextView = findViewById<TextView>(R.id.personNameTextView)
        personNameTextView.text = personName

        val callBtn = findViewById<ImageButton>(R.id.callBtn)
        callBtn.setOnClickListener {
            val intentCall = Intent(this, call::class.java)
            startActivity(intentCall)
        }
    }
}