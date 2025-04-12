package trig_task.math

import kotlin.math.abs
import kotlin.math.floor

object BasicFun {
    private val sinMap = HashMap<Double, Double>()
    private val lnMap = HashMap<Double, Double>()

    fun sin(x: Double): Double {
        var res = .0
        var prevRes = -Double.MAX_VALUE
        var fact = -1.0
        var i = 1
        val value = normalizeAngleToMinusPiPi(x)

        if (sinMap.containsKey(x)) return sinMap.getValue(x)

        while (abs(res - prevRes) > 1e-10) {
            if (i % 2 == 0) {
                fact *= value / i
                i++
                continue
            }
            prevRes = res
            fact *= -1 * value / i
            res += fact
            i++
        }

        sinMap[x] = res

        return res
    }

    fun ln(x: Double): Double {
        if (x <= 0) {
            throw IllegalArgumentException("x must be positive")
        }

        var value = x
        var iters = 0
        var res = .0
        var prevRes = -Double.MAX_VALUE
        var fact = -1.0
        var n = 1.0

        if (lnMap.containsKey(x)) return lnMap.getValue(x)

        while (value > 2) {
            value /= Math.E
            iters++
        }

        while (value < 1.0) {
            value *= Math.E
            iters--
        }

        while (abs(res - prevRes) > 1e-10) {
            prevRes = res
            fact *= -1 * (value - 1)
            res += fact / n
            n += 1.0
        }

        lnMap[x] = res + iters

        return res + iters
    }

    private fun normalizeAngleToMinusPiPi(angle: Double): Double {
        val normalized2Pi = angle - 2 * Math.PI * floor(angle / (2 * Math.PI))

        return if (normalized2Pi > Math.PI) normalized2Pi - 2 * Math.PI else normalized2Pi
    }
}