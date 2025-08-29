
package com.example.kotlinscannerapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val prices = listOf(100.0, 102.0, 101.0, 103.0, 105.0, 104.0, 106.0, 107.0, 108.0, 110.0, 109.0, 111.0, 112.0, 113.0, 114.0)
        val rsi = Indicators.calculateRSI(prices)
        val macd = Indicators.calculateMACD(prices)
        val bollinger = Indicators.calculateBollingerBands(prices)

        val resultText = """RSI: $rsi
MACD: ${macd.first}, Signal: ${macd.second}
Bollinger Bands: Upper=${bollinger.first}, Lower=${bollinger.second}"""

        findViewById<TextView>(R.id.resultTextView).text = resultText
    }
}
