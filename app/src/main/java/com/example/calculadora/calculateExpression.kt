package com.example.calculadora

fun MainActivity.evaluateExpression(string: String, clear: Boolean) {
    if (clear) {
        result.text = ""
        expression.append(string)
    } else {
        expression.append(result.text)
        expression.append(string)
        result.text = ""
    }
}