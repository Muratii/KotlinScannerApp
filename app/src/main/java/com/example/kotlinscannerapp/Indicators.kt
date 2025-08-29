package com.example.kotlinscannerapp

object Indicators {
    fun calculateRSI(prices: List<Float>): Float {
        if (prices.size < 2) return 0f
        var gain = 0f
        var loss = 0f
        for (i in 1 until prices.size) {
            val change = prices[i] - prices[i - 1]
            if (change > 0) gain += change else loss -= change
        }
        val rs = if (loss == 0f) 100f else gain / loss
        return 100 - (100 / (1 + rs))
    }

    fun calculateMACD(prices: List<Float>): Float {
        val ema12 = prices.takeLast(12).average().toFloat()
        val ema26 = prices.takeLast(26).average().toFloat()
        return ema12 - ema26
    }

    fun calculateBollingerBands(prices: List<Float>): Pair<Float, Float> {
        val mean = prices.average().toFloat()
        val stdDev = kotlin.math.sqrt(prices.map { (it - mean) * (it - mean) }.average()).toFloat()
        return Pair(mean - 2 * stdDev, mean + 2 * stdDev)
    }
}
