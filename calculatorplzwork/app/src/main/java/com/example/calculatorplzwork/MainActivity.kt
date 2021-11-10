package com.example.calculatorplzwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView
    private var operand: Double = 0.0
    private var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)
    }

    fun numberClick(clickedView: View){
        if (clickedView is TextView){
            var result = resultTextView.text.toString()
            val number = clickedView.text.toString()

            if (result == "0"){
                result = ""
            }
            resultTextView.text = result + number
        }
    }

    fun operationClick(clickedView: View){
        if (clickedView is TextView) {
            val result = resultTextView.text.toString()
            if (result.isNotEmpty()){
                operand = result.toDouble()
            }
            operation = clickedView.text.toString()
            resultTextView.text = ""
        }
    }
    fun equalsClick(clickedView: View){
        val secondopText: String = resultTextView.text.toString()
        var secondop: Double = 0.0
        if(secondopText.isNotEmpty()){
            secondop = secondopText.toDouble()
        }

        when(operation){
            "+" -> resultTextView.text = (operand + secondop).toString()
            "-" -> resultTextView.text = (operand - secondop).toString()
            "*" -> resultTextView.text = (operand * secondop).toString()
            "÷" -> resultTextView.text = (operand / secondop).toString()
            "%" -> resultTextView.text = ((operand * secondop)/100).toString()
            "clear" -> resultTextView.text = ""
            "√" -> resultTextView.text =
        }
    }
}