package com.example.budgetbuddy

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var etNewUsername: EditText
    private lateinit var etNewPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var btnRegister: Button
    private lateinit var tvBackToLogin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Initialize UI components
        etNewUsername = findViewById(R.id.etNewUsername)
        etNewPassword = findViewById(R.id.etNewPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        btnRegister = findViewById(R.id.btnRegister)
        tvBackToLogin = findViewById(R.id.tvBackToLogin)

        // Handle register button click
        btnRegister.setOnClickListener {
            val username = etNewUsername.text.toString().trim()
            val password = etNewPassword.text.toString().trim()
            val confirmPassword = etConfirmPassword.text.toString().trim()

            // Validate user input before saving
            if (username.isEmpty()) {
                etNewUsername.error = "Please enter username"
                etNewUsername.requestFocus()
                Log.d("Register", "Registration failed: username field empty")
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                etNewPassword.error = "Please enter password"
                etNewPassword.requestFocus()
                Log.d("Register", "Registration failed: password field empty")
                return@setOnClickListener
            }

            if (confirmPassword.isEmpty()) {
                etConfirmPassword.error = "Please confirm password"
                etConfirmPassword.requestFocus()
                Log.d("Register", "Registration failed: confirm password field empty")
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                etConfirmPassword.error = "Passwords do not match"
                etConfirmPassword.requestFocus()
                Log.d("Register", "Registration failed: passwords do not match")
                return@setOnClickListener
            }

            // Save user details locally using SharedPreferences
            val sharedPref = getSharedPreferences("UserData", MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.putString("username", username)
            editor.putString("password", password)
            editor.apply()

            Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()
            Log.d("Register", "User registered successfully")

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Navigate back to login screen
        tvBackToLogin.setOnClickListener {
            Log.d("Register", "Navigating back to LoginActivity")
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}