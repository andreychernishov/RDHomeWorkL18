package com.example.rdhomeworkl18.Singleton
//створення сінглтону старим методом
//при створенні сінглтону - приватний конструктор
class Singleton private constructor(){
    //статичне поле
    companion object{
        private var instance: Singleton? = null
        fun getInstance() : Singleton{
            return instance ?: Singleton()
        }
    }
}
//новий метод створення сінгтону
object DataHolder{
    var counter : Int = 0
    fun plus(){
        counter++
    }
    fun minus(){
        counter--
    }
}