package com.example.rdhomeworkl18.mvvm

import com.example.rdhomeworkl18.SharedPreferences.MyApplication

object ModelImpl: ModelInterface {
    private var counter: Int = 0
    init {
        val savedCounter = MyApplication.getApp().getSavedData()
        if (savedCounter != 0){
            counter = savedCounter
        }
    }

    override fun getCounter(): Int{
        return counter
    }
    override fun plus(){
        counter++
    }
    override fun minus(){
        counter--
    }
}