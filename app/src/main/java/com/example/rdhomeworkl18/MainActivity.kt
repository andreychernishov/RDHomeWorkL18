package com.example.rdhomeworkl18

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.rdhomeworkl18.mvvm.Intent
import com.example.rdhomeworkl18.mvvm.MyViewModel
import com.example.rdhomeworkl18.mvvm.UIState


class MainActivity: AppCompatActivity(){
    private var mainTv: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_layout)
        mainTv = findViewById(R.id.main_tv)
        val btnPlus: Button = findViewById(R.id.plus_btn)
        val btnMinus: Button = findViewById(R.id.minus_btn)

        val viewModel: MyViewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        viewModel.uiStateLiveData.observe(this){ UIState ->
            when(UIState){
                is UIState.EmptyListUI -> Unit
                is UIState.FilledList -> {
                    mainTv?.text = UIState.counter.toString()
                }

            }
        }

        btnPlus.setOnClickListener {
            //viewModel.plus()
            viewModel.intentLiveData.value = Intent.plusCounter
        }
        btnMinus.setOnClickListener {
           // viewModel.minus()
            viewModel.intentLiveData.value = Intent.minusCounter
        }
    }
}