package com.example.klab2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var text = "null"
    private var counter = 0
    private var EXTRA_KEY = "active"

    private fun startSecondActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        val textView: TextView = findViewById(R.id.textView)
        intent.putExtra(EXTRA_KEY, textView?.text.toString())
        startActivity(intent)
    }

    private fun openFragmentOne(){
        val fragmentOne = FragmentOne()

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragmentOne)
            .addToBackStack(null)
            .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("Create")

        val textView: TextView = findViewById(R.id.textView)
        val button: Button = findViewById(R.id.button)
        val editText: EditText = findViewById(R.id.editTextTextMultiLine)


        button.setOnClickListener {
            if (editText.text.isNotEmpty()) {
                textView.text = editText.text
            } else {
                counter++
                textView.text = counter.toString()
            }
        }

        val buttonNext: Button = findViewById(R.id.buttonNextActivity)

        buttonNext.setOnClickListener {
            startSecondActivity()
        }

        val buttonFragment: Button = findViewById(R.id.buttonFragment)

        buttonFragment.setOnClickListener {
            openFragmentOne()
        }
    }

    override fun onStart(){
        super.onStart()
        println("onStart")
    }

    override fun onResume(){
        super.onResume()
        println("onResume")
    }

    override fun onPause(){
        super.onPause()
        println("onPause")
    }

    override fun onStop(){
        super.onStop()
        println("onStop")
    }

    override fun onDestroy(){
        super.onDestroy()
        println("onDestroy")
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        val textView: TextView = findViewById(R.id.textView)
        text = textView.text.toString()
        savedInstanceState.putString("message", text)
        savedInstanceState.putInt("counter", counter)
    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val textView: TextView = findViewById(R.id.textView)
        textView.text = savedInstanceState.getString("message")
        counter = savedInstanceState.getInt("counter")
    }
}