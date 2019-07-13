package com.example.mvvmapplication.ui.passdata

import com.example.mvvmapplication.base.BaseViewModel
import androidx.lifecycle.MutableLiveData



class DataPassViewModel : BaseViewModel(){
    private val numberCount = MutableLiveData<String>()

    fun selectData(incre: Int) {
        numberCount.value=incre.toString()
    }

    fun getNumberCount(): MutableLiveData<String> {
        return numberCount
    }


}