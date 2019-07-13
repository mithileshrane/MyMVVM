package com.example.mvvmapplication.ui.passdata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity;
import com.example.mvvmapplication.R

import kotlinx.android.synthetic.main.activity_double_activty.*

class DoubleActivty : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_double_activty)
        setSupportActionBar(toolbar)

        supportFragmentManager.beginTransaction()
            .add(R.id.clPart1,
                OneFragment(),
                OneFragment::class.java.simpleName)
            .commit()

        supportFragmentManager.beginTransaction()
            .add(R.id.clPart2,
                TwoFragment(),
                TwoFragment::class.java.simpleName)
            .commit()
    }


}
