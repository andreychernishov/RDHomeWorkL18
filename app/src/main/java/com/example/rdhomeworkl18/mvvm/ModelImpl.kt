package com.example.rdhomeworkl18.mvvm

object ModelImpl: ModelInterface {
    private var counter = 0

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