package com.example.rdhomeworkl18.Application

import android.app.Application

//збереження даних на екрані метод2 за допомогою классу Application
class MyApplication: Application() {
    var counter: Int = 0

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
    companion object{

        private lateinit var instance: MyApplication
        fun getApp() = instance
    }

    fun plus(){
        counter++
    }
    fun minus(){
        counter--
    }

}