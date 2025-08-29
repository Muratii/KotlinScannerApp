package com.example.scanner

object Indicators {

    fun calculateRSI(prices: List<Double>, period: Int = 14): Double {
        if (prices.size < period + 1) return 0.0
        var gains = 0.0
        var losses = 0.0
        for (i in 1..period) {
            val change = prices[i] - prices[i - 1]
            if (change > 0) gains += change else losses -= change
        }
        val rs = if (losses == 0.0) return 100.0 else gains / losses
        return 100 - (100 / (1 + rs))
    }

    fun calculateMACD(prices: List<Double>, shortPeriod: Int = 12, longPeriod: Int = 26): Double {
        if (prices.size < longPeriod) return 0.0
        val shortEMA = prices.takeLast(shortPeriod).average()
        val longEMA = prices.takeLast(longPeriod).average()
        return shortEMA - longEMA
    }

    fun calculateBollingerBands(prices: List<Double>, period: Int = 20): Triple<Double, Double, Double> {
        if (prices.size < period) return Triple(0.0, 0.0, 0.0)
        val recentPrices = prices.takeLast(period)
        val mean = recentPrices.average()
        val stdDev = kotlin.math.sqrt(recentPrices.map { (it - mean) * (it - mean) }.average())
        return Triple(mean + 2 * stdDev, mean, mean - 2 * stdDev)
    }
}
