package com.example.rdhomeworkl18

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.rdhomeworkl18.ModelViewPresenter.MyView
import com.example.rdhomeworkl18.ModelViewPresenter.Presenter
import com.example.rdhomeworkl18.ModelViewPresenter.PresenterImpl

var mainTv: TextView? = null
val presenter: Presenter = PresenterImpl()

class MainActivity: Activity(), MyView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_layout)
        mainTv = findViewById(R.id.main_tv)

        val btnPlus: Button = findViewById(R.id.plus_btn)
        val btnMinus: Button = findViewById(R.id.minus_btn)
        presenter.setView(this)
        btnPlus.setOnClickListener {
            presenter.plus()
        }
        btnMinus.setOnClickListener {
            presenter.minus()

        }

    }

    override fun updateCounter(counter: Int) {
        mainTv?.text = counter.toString()
    }
}