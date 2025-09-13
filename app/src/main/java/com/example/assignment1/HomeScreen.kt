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
import android.widget.TextView


class HomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val imageUriString = intent.getStringExtra("PROFILE_IMAGE_URI")
        val profileImageView = findViewById<ImageView>(R.id.profileImageView)
        val profileImageInFeed = findViewById<ImageButton>(R.id.tab_5)
        // Set the image URI to the ImageView
        if (imageUriString!=null) {
            val imageUri = Uri.parse(imageUriString)
            profileImageView.setImageURI(imageUri)
            profileImageInFeed.setImageURI(imageUri)
        }

        val username = intent.getStringExtra("USERNAME_KEY")
        val usernameTextView = findViewById<TextView>(R.id.usernameTextView) // Make sure this ID exists

        // Set the username to a TextView
        usernameTextView.text = username

        val searchBtn=findViewById<ImageButton>(R.id.tab_2_search)

        searchBtn.setOnClickListener {
            val intentSearch = Intent(this, search::class.java)
            if (imageUriString != null) {
                val imageUri = Uri.parse(imageUriString)
                intentSearch.putExtra("PROFILE_IMAGE_URI", imageUri.toString()) // Convert URI to String before sending
            }
            startActivity(intentSearch)
        }

        val shareBtn= findViewById<ImageButton>(R.id.shareButton)
        shareBtn.setOnClickListener {
            val intentShare=Intent(this, )
        }
    }
}