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



class signup : AppCompatActivity() {

    private lateinit var profileImageView: ImageView
    private lateinit var cameraButton: ImageButton

    private lateinit var dobEditText: TextInputEditText

    private val pickImage = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            profileImageView.setImageURI(it)
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


        cameraButton.setOnClickListener {
            pickImage.launch("image/*")  // Filter only images
        }

        dobEditText = findViewById(R.id.dobEditText)

        dobEditText.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
                val formattedDate = String.format("%02d/%02d/%04d", selectedDay, selectedMonth + 1, selectedYear)
                dobEditText.setText(formattedDate)
            }, year, month, day).show()
        }



        val btnCreatAccount = findViewById<AppCompatButton>(R.id.createAccountBtn)

        btnCreatAccount.setOnClickListener {
            val usernameEditText: EditText = findViewById(R.id.userName1)
            val username = usernameEditText.text.toString().trim()

            val intentSignup = Intent(this, login2::class.java)
            intentSignup.putExtra("USERNAME_KEY", username) // attach here!
            startActivity(intentSignup)
        }

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        findViewById<MaterialToolbar>(R.id.toolbar).setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }


    }
}