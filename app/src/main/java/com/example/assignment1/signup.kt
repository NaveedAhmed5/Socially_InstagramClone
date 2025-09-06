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
import java.util.*



class signup : AppCompatActivity() {

    private lateinit var profileImageView: ImageView
    private lateinit var cameraButton: ImageButton

    private lateinit var dobEditText: TextInputEditText

    // Register the result launcher for picking an image
    private val pickImage = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            profileImageView.setImageURI(it)  // Display chosen image
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        profileImageView = findViewById(R.id.cameraButton)
        cameraButton = findViewById(R.id.cameraButton)

        // On button click, launch gallery
        cameraButton.setOnClickListener {
            pickImage.launch("image/*")  // Filter only images
        }

        dobEditText = findViewById(R.id.dobEditText)

        dobEditText.setOnClickListener {
            // Get current date as default
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
                // Format date as DD/MM/YYYY
                val formattedDate = String.format("%02d/%02d/%04d", selectedDay, selectedMonth + 1, selectedYear)
                dobEditText.setText(formattedDate)
            }, year, month, day).show()
        }

        val btnCreatAccount = findViewById<AppCompatButton>(R.id.createAccountBtn)

        btnCreatAccount.setOnClickListener {
            val intentSignup = Intent(this, login2::class.java)
            startActivity(intentSignup)
        }

    }
}