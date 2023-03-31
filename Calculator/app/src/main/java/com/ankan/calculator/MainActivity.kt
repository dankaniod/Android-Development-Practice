package com.ankan.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val num1 = findViewById<EditText>(R.id.etEnterNumber1)
        val num2 = findViewById<EditText>(R.id.etEnterNumber2)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSub = findViewById<Button>(R.id.btnSub)
        val btnDiv = findViewById<Button>(R.id.btnDiv)
        val btnMul = findViewById<Button>(R.id.btnMul)
        var result = 0
        val number1 = num1.toString().toInt()
        val number2 = num2.toString().toInt()
        val intent = Intent(this, SecondActivity::class.java)
        btnAdd.setOnClickListener {
            result = (number1+number2)
            intent.putExtra("result", result)
            startActivity(intent)
        }
        btnSub.setOnClickListener {
            result = (number1-number2)
            intent.putExtra("result", result)
            startActivity(intent)
        }
        btnMul.setOnClickListener {
            result = (number1*number2)
            intent.putExtra("result", result)
            startActivity(intent)
        }
        btnDiv.setOnClickListener {
            result = (number1/number2)
            intent.putExtra("result", result)
            startActivity(intent)
        }
    }
}