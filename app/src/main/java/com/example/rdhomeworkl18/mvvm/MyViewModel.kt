package com.example.rdhomeworkl18.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {
    private val model: ModelInterface = ModelImpl
    val counterLiveData = MutableLiveData(model.getCounter())
    fun plus(){
        model.plus()
        counterLiveData.value = model.getCounter()
    }
    fun minus(){
        model.minus()
        counterLiveData.value = model.getCounter()
    }
}