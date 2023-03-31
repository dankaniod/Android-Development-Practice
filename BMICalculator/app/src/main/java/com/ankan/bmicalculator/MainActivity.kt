package com.ankan.bmicalculator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val heightText = findViewById<EditText>(R.id.etHeight)
        val weightText = findViewById<EditText>(R.id.etWeight)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val cardViewBMI = findViewById<CardView>(R.id.cvBMI)
        cardViewBMI.visibility = INVISIBLE
        btnCalculate.setOnClickListener {
            val weight = weightText.text.toString()
            val height = heightText.text.toString()
            if (validateInput(weight, height)) {
                it.hideKeyboard()
                cardViewBMI.visibility = VISIBLE
                var bmi = weight.toFloat() / (((height.toFloat() * height.toFloat())) / 10000)
                bmi = String.format("%.2f", bmi).toFloat()
                displayResult(bmi)
            }
            else {
                cardViewBMI.visibility = INVISIBLE
            }
        }
    }
    fun View.hideKeyboard() {
        val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(windowToken, 0)
    }
    private fun validateInput(weight:String?, height:String?):Boolean {
        return when {
            height.isNullOrEmpty() -> {
                Toast.makeText(this, "Height is empty", Toast.LENGTH_SHORT).show()
                false
            }
            weight.isNullOrEmpty() -> {
                Toast.makeText(this, "Weight is empty", Toast.LENGTH_SHORT).show()
                false
            }
            else -> {
                true
            }
        }
    }

    private fun displayResult(bmi:Float) {
        val resultBMI = findViewById<TextView>(R.id.tvBMI)
        val resultHealth = findViewById<TextView>(R.id.tvHealth)
        val resultRange = findViewById<TextView>(R.id.tvRange)

        resultBMI.text = bmi.toString()
        resultRange.text = "Normal range is 18.5 - 24.9"

        var resultText = ""
        var color = 0

        when {
            bmi < 18.5 -> {
                resultText = "Underweight"
                color = R.color.underweight
            }
            bmi in 18.50..24.99 -> {
                resultText = "Healthy"
                color = R.color.normal
            }
            bmi in 25.00..29.99 -> {
                resultText = "Overweight"
                color = R.color.overweight
            }
            bmi > 29.99 -> {
                resultText = "Obese"
                color = R.color.obese
            }
        }
        resultHealth.text = resultText
        resultHealth.setTextColor(ContextCompat.getColor(this,color))
    }
}