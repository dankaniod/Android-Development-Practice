package com.ankan.viewmodeldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainActivityViewModel
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        val tvCount = findViewById<TextView>(R.id.tvCount)
        val btnCount = findViewById<Button>(R.id.btnCount)
//        tvCount.text = count.toString()
//        tvCount.text = viewModel.count.value.toString()
        viewModel.count.observe(this, Observer {
            tvCount.text = it.toString()
        })
        btnCount.setOnClickListener {
//            count++
            viewModel.updateCount()
//            tvCount.text = viewModel.count.value.toString()
        }
    }
}