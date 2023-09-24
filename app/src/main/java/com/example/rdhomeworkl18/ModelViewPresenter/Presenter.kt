package com.example.rdhomeworkl18.ModelViewPresenter


interface Presenter {
    fun plus()
    fun minus()
    fun setView(view: MyView)
}