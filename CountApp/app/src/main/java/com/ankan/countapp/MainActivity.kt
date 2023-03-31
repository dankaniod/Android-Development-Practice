package com.ankan.countapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private var count:Int = 0
    private lateinit var viewModel:MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        val tvCount = findViewById<TextView>(R.id.tvCount)
        val btnCount = findViewById<Button>(R.id.btnCount)
        tvCount.text = count.toString()
        btnCount.setOnClickListener(View.OnClickListener {
            count++
            tvCount.text = count.toString()
        })
    }
}

private fun ViewModelProvider.get(modelClass: Class<MainActivityViewModel>): MainActivityViewModel {

}
