package com.ankan.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val result = intent.getStringExtra("result")
        var tvResult = findViewById<TextView>(R.id.tvResult)
        val btnBack = findViewById<Button>(R.id.btnBack)
        val intent = Intent(this, MainActivity::class.java)
        tvResult.text = result.toString()
        btnBack.setOnClickListener {
            startActivity(intent)
        }
    }
}