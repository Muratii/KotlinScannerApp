
package com.example.kotlinscannerapp

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sqrt

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

    fun calculateMACD(prices: List<Double>, shortPeriod: Int = 12, longPeriod: Int = 26, signalPeriod: Int = 9): Pair<Double, Double> {
        fun ema(prices: List<Double>, period: Int): List<Double> {
            val k = 2.0 / (period + 1)
            val ema = mutableListOf(prices[0])
            for (i in 1 until prices.size) {
                ema.add(prices[i] * k + ema[i - 1] * (1 - k))
            }
            return ema
        }
        val shortEMA = ema(prices, shortPeriod)
        val longEMA = ema(prices, longPeriod)
        val macdLine = shortEMA.zip(longEMA) { s, l -> s - l }
        val signalLine = ema(macdLine, signalPeriod)
        return Pair(macdLine.last(), signalLine.last())
    }

    fun calculateBollingerBands(prices: List<Double>, period: Int = 20): Pair<Double, Double> {
        if (prices.size < period) return Pair(0.0, 0.0)
        val recentPrices = prices.takeLast(period)
        val mean = recentPrices.average()
        val stdDev = sqrt(recentPrices.map { (it - mean) * (it - mean) }.average())
        return Pair(mean + 2 * stdDev, mean - 2 * stdDev)
    }
}
