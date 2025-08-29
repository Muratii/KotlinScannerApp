package com.example.kotlinscannerapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resultView = findViewById<TextView>(R.id.resultView)
        val prices = listOf(100.0, 102.0, 101.0, 103.0, 105.0, 104.0, 106.0, 107.0, 108.0, 110.0, 109.0, 111.0, 112.0, 113.0)
        val rsi = Indicators.calculateRSI(prices)
        val macd = Indicators.calculateMACD(prices)
        val bollinger = Indicators.calculateBollingerBands(prices)

        resultView.text = "RSI: %.2f\nMACD: %.2f\nBollinger Bands: %.2f - %.2f".format(rsi, macd, bollinger.first, bollinger.second)
    }
}
