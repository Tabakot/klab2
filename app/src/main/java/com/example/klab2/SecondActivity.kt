package com.example.klab2;

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private var EXTRA_KEY = "active"

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val data = intent.extras?.getString(EXTRA_KEY)

        val textView: TextView = findViewById(R.id.textView2)

        textView.text = data
    }
}
