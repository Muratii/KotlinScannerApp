package com.example.kotlinscannerapp

object Indicators {
    fun calculateRSI(prices: List<Double>, period: Int = 14): Double {
        if (prices.size < period + 1) return 0.0
        var gain = 0.0
        var loss = 0.0
        for (i in 1..period) {
            val change = prices[i] - prices[i - 1]
            if (change > 0) gain += change else loss -= change
        }
        val rs = if (loss == 0.0) 100.0 else gain / loss
        return 100 - (100 / (1 + rs))
    }

    fun calculateMACD(prices: List<Double>): Double {
        val shortEMA = prices.takeLast(12).average()
        val longEMA = prices.takeLast(26).average()
        return shortEMA - longEMA
    }

    fun calculateBollingerBands(prices: List<Double>, period: Int = 20): Pair<Double, Double> {
        if (prices.size < period) return Pair(0.0, 0.0)
        val recentPrices = prices.takeLast(period)
        val mean = recentPrices.average()
        val stdDev = kotlin.math.sqrt(recentPrices.map { (it - mean) * (it - mean) }.average())
        return Pair(mean - 2 * stdDev, mean + 2 * stdDev)
    }
}
