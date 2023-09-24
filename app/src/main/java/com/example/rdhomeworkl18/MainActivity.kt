package com.example.rdhomeworkl18

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class MainActivity: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_layout)

        val mainTv: TextView = findViewById(R.id.main_tv)
        val btnPlus: Button = findViewById(R.id.plus_btn)
        val btnMinus: Button = findViewById(R.id.minus_btn)
    }
}