package com.example.rdhomeworkl18.SharedPreferences

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MyApplication: Application() {

    private lateinit var sharedPrefs: SharedPreferences
    private var gson = Gson()

    override fun onCreate() {
        super.onCreate()
        instance = this
        sharedPrefs = getSharedPreferences("MyPrefs",Context.MODE_PRIVATE)
    }

    fun saveData(counter: Int){
        val counterToSave = gson.toJson(counter)
        sharedPrefs.edit().putString("MyCounter",counterToSave).apply()
    }

    fun getSavedData(): Int{
        val jsonCounter = sharedPrefs.getInt("MyCounter", 0)
        var result = 0
        if (jsonCounter != 0){
            val type = object : TypeToken<Int>() {}.type
            result = gson.fromJson(jsonCounter.toString(), type)
        }
        return result
    }

    companion object{
        private lateinit var instance: MyApplication
        fun getApp() = instance
    }

}