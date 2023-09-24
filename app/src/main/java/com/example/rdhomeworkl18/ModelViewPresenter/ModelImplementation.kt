package com.example.rdhomeworkl18.ModelViewPresenter

object ModelImplementation : ModelInterface {
    private var counter: Int = 0
    override fun getCounter(): Int {
        return counter
    }
    override fun plus() {
        counter++
    }
    override fun minus() {
        counter--
    }
}