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
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView

class messageList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_message_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val sharedPref = getSharedPreferences("MyAppPrefs", MODE_PRIVATE)
        val username = sharedPref.getString("USERNAME_KEY", "Guest")
        val imageUri = sharedPref.getString("IMAGE_URI_KEY", null)


        val usernameTextView = findViewById<TextView>(R.id.header_title) // Make sure this ID exists
        // Set the username to a TextView
        usernameTextView.text = username

        val chatPersonName: TextView=findViewById<TextView>(R.id.chatPersonName)
        val personName = chatPersonName.text.toString().trim()


        val chatBtn = findViewById<LinearLayout>(R.id.DannyChat)
        chatBtn.setOnClickListener {
            val intentChat = Intent(this, chat::class.java)
            intentChat.putExtra("PersonName", personName)
            startActivity(intentChat)
        }

    }
}