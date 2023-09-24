package com.example.rdhomeworkl18

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.rdhomeworkl18.mvvm.MyViewModel


class MainActivity: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_layout)
        val mainTv: TextView = findViewById(R.id.main_tv)
        val btnPlus: Button = findViewById(R.id.plus_btn)
        val btnMinus: Button = findViewById(R.id.minus_btn)

        val viewModel: MyViewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        viewModel.counterLiveData.observe(this){counter ->
            mainTv.text = counter.toString()
        }
        btnPlus.setOnClickListener {
            viewModel.plus()
        }
        btnMinus.setOnClickListener {
            viewModel.minus()
        }
    }
}