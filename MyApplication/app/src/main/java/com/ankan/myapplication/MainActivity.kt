package com.ankan.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.content.SharedPreferences

class MainActivity : AppCompatActivity() {
    private lateinit var num1 : EditText
    private lateinit var num2 : EditText
    private lateinit var sf : SharedPreferences
    private lateinit var sfEdit : SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        num1 = findViewById(R.id.etEnterNumber1)
        num2 = findViewById(R.id.etEnterNumber2)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSub = findViewById<Button>(R.id.btnSub)
        val btnDiv = findViewById<Button>(R.id.btnDiv)
        val btnMul = findViewById<Button>(R.id.btnMul)
        var result = ""
        val intent = Intent(this, SecondActivity::class.java)
        sf = getSharedPreferences("sf_main", MODE_PRIVATE)
        sfEdit = sf.edit()
        btnAdd.setOnClickListener {
            val number1 = num1.text.toString().toInt()
            val number2 = num2.text.toString().toInt()
            result = (number1+number2).toString()
            intent.putExtra("result", result)
            startActivity(intent)
        }
        btnSub.setOnClickListener {
            val number1 = num1.text.toString().toInt()
            val number2 = num2.text.toString().toInt()
            result = (number1-number2).toString()
            intent.putExtra("result", result)
            startActivity(intent)
        }
        btnMul.setOnClickListener {
            val number1 = num1.text.toString().toInt()
            val number2 = num2.text.toString().toInt()
            result = (number1*number2).toString()
            intent.putExtra("result", result)
            startActivity(intent)
        }
        btnDiv.setOnClickListener {
            val number1 = num1.text.toString().toInt()
            val number2 = num2.text.toString().toInt()
            result = (number1 / number2).toString()
            intent.putExtra("result", result)
            startActivity(intent)
        }
    }

    override fun onPause() {
        super.onPause()
        val number1 = num1.text.toString()
        val number2 = num2.text.toString()
        sfEdit.apply {
            putString("sf_main_num1", number1)
            putString("sf_main_num2", number2)
            commit()
        }
    }

    override fun onResume() {
        super.onResume()
        val number1 = sf.getString("sf_main_num1", null)
        val number2 = sf.getString("sf_main_num2", null)
        num1.setText(number1)
        num2.setText(number2)
    }
}