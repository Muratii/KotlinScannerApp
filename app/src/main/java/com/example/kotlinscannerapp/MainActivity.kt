package com.example.kotlinscannerapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val prices = listOf(100f, 102f, 101f, 103f, 105f, 104f, 106f, 107f, 108f, 110f, 109f, 111f, 112f, 113f, 114f)
        val rsi = Indicators.calculateRSI(prices)
        val macd = Indicators.calculateMACD(prices)
        val bollinger = Indicators.calculateBollingerBands(prices)

        val resultText = findViewById<TextView>(R.id.resultText)
        resultText.text = "RSI: $rsi\nMACD: $macd\nBollinger Bands: $bollinger"
    }
}
