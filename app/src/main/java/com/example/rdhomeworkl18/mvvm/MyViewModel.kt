package com.example.rdhomeworkl18.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.rdhomeworkl18.SharedPreferences.MyApplication
import kotlin.math.min

class MyViewModel: ViewModel() {
    private val model: ModelInterface = ModelImpl
    val uiStateLiveData = MutableLiveData<UIState>(UIState.EmptyListUI)
    val intentLiveData = MutableLiveData<Intent>()
    private val observerPlus = Observer<Intent>{
        if (model.getCounter() <= 0){
            minus()
        }
        if (model.getCounter() >= 0 ){
            plus()
        }
    }
    init {
        intentLiveData.observeForever(observerPlus)
        if (model.getCounter() != 0){
            uiStateLiveData.value = UIState.FilledList(model.getCounter())
        }
    }
    fun plus(){
        model.plus()
        uiStateLiveData.value = UIState.FilledList(model.getCounter())
    }
    fun minus(){
        model.minus()
        uiStateLiveData.value = UIState.FilledList(model.getCounter())
    }
    override fun onCleared() {
        super.onCleared()
        intentLiveData.removeObserver(observerPlus)
        MyApplication.getApp().saveData(model.getCounter())
    }
}
sealed class UIState{
    object EmptyListUI: UIState()
    class FilledList(val counter: Int): UIState()
}
sealed class Intent{
    object plusCounter: Intent()
    object minusCounter: Intent()
}