package com.example.calculadora

import android.widget.TextView
import android.widget.Toast
import net.objecthunter.exp4j.ExpressionBuilder

fun MainActivity.setupNumberButtons() {
    val numberButtons = listOf(
        findViewById<TextView>(R.id.zeroButton),
        findViewById(R.id.oneButton),
        findViewById(R.id.twoButton),
        findViewById(R.id.threeButton),
        findViewById(R.id.fourButton),
        findViewById(R.id.fiveButton),
        findViewById(R.id.sixButton),
        findViewById(R.id.sevenButton),
        findViewById(R.id.eightButton),
        findViewById(R.id.nineButton)
    )

    numberButtons.forEachIndexed { index, button ->
        button.setOnClickListener {
            evaluateExpression(index.toString(), clear = true)
        }
    }
}

fun MainActivity.setupOperatorButtons() {
    val operatorButtons = listOf(
        Pair(R.id.plusOperator, "+"),
        Pair(R.id.minusOperator, "-"),
        Pair(R.id.multOperator, "*"),
        Pair(R.id.divideOperator, "/"),
        Pair(R.id.dotButton, ".")
    )

    operatorButtons.forEach { (buttonId, operator) ->
        findViewById<TextView>(buttonId).setOnClickListener {
            evaluateExpression(operator, clear = true)
        }
    }
}

fun MainActivity.setupClearButton() {
    findViewById<TextView>(R.id.clear).setOnClickListener {
        expression.text = ""
        result.text = ""
    }
}

fun MainActivity.setupEqualsButton() {
    findViewById<TextView>(R.id.equalsOperator).setOnClickListener {
        try {
            val text = expression.text.toString()
            val expression = ExpressionBuilder(text).build()

            val result = expression.evaluate()
            val longResult = result.toLong()
            this.result.text = if (result == longResult.toDouble()) {
                longResult.toString()
            } else {
                result.toString()
            }
        } catch (e: IllegalArgumentException) {
            Toast.makeText(this, "Insira uma expressao valida!", Toast.LENGTH_LONG).show()
            this.expression.text = ""
        }
    }
}

fun MainActivity.setupDelButton() {
    findViewById<TextView>(R.id.delButton).setOnClickListener {
        val text = expression.text.toString()
        if (text.isNotEmpty()) {
            expression.text = text.dropLast(1)
        }
        result.text = ""
    }
}