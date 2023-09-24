package com.example.rdhomeworkl18

import android.app.Activity
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.widget.Button
import android.widget.TextView
import com.example.rdhomeworkl18.Application.MyApplication
import com.example.rdhomeworkl18.Singleton.DataHolder

class MainActivity: Activity() {
//    for Bundle
    var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_layout)

        val mainTv : TextView = findViewById(R.id.main_tv)
        val btnPlus: Button = findViewById(R.id.plus_btn)
        val btnMinus: Button = findViewById(R.id.minus_btn)
        //add val application for 2nd method
//        val application = MyApplication.getApp()
        //Check application for empty
//        if (application.counter != 0){
//            mainTv.text = application.counter.toString()
//        }
//        2nd method works

        //check Singleton for empty
//        if (DataHolder.counter != 0){
//            mainTv.text = DataHolder.counter.toString()
//        }
//        works

//        Check Bundle
        if (savedInstanceState != null){
            counter = savedInstanceState.getString(ITEMS_FOR_BUNDLE)!!.toInt()
            mainTv.text = counter.toString()
        }
        //works

        btnPlus.setOnClickListener {
//            singleton method
//            DataHolder.plus()
//            mainTv.text = DataHolder.counter.toString()
//
//                     application method
//            application.plus()
//            mainTv.text = application.counter.toString()
//
        //            Bundle
            counter++
            mainTv.text = counter.toString()

        }
        btnMinus.setOnClickListener {
//            DataHolder.minus()
//            mainTv.text = DataHolder.counter.toString()
//                    application method
//            application.minus()
//            mainTv.text = application.counter.toString()
//
//                  Bundle
            counter--
            mainTv.text = counter. toString()
        }
    }

//    saving data by Bundle
    override fun onSaveInstanceState(outState: Bundle) {
    outState.putString(ITEMS_FOR_BUNDLE,counter.toString())
    super.onSaveInstanceState(outState)
    }
    companion object{
        const val ITEMS_FOR_BUNDLE = "items_key"
    }

}