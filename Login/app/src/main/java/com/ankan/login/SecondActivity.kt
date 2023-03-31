package com.ankan.login

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private lateinit var welcomeTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Initialize views
        welcomeTextView = findViewById<TextView>(R.id.welcome_text)

        // Get username from intent
        val username = intent.getStringExtra("username")

        // Display welcome message
        welcomeTextView.text = "Welcome, $username!"
    }
}
