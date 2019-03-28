package com.androidabcd.ashokslsk.aac

import android.databinding.ObservableField

/**
 * Created by Srinivasa Ashok Kumar on 28/03/19.
 */

class CounterViewModel{
    var counter = 0
    var clicked = ObservableField("Clicked "+counter+" Times")
    fun CounterClicked(){
        counter++
        clicked.set("Clicked "+counter+" Times")
    }
}