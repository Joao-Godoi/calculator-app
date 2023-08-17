package com.example.calculadora

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var expression: TextView
    lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        expression = findViewById(R.id.expressionToCalculate)
        result = findViewById(R.id.result)

        setupNumberButtons()
        setupOperatorButtons()
        setupClearButton()
        setupEqualsButton()
        setupDelButton()
    }
}