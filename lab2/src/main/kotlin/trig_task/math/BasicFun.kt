package trig_task.math

import trig_task.IBasicFun
import kotlin.math.abs
import kotlin.math.floor
import kotlin.math.pow
import kotlin.math.sqrt

object BasicFun : IBasicFun{
    private val sinMap = HashMap<Double, Double>()
    private val lnMap = HashMap<Double, Double>()

    override fun sin(x: Double): Double {
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

    override fun cos(x: Double) = if (abs(normalizeAngleToMinusPiPi(x)) <= Math.PI) {
        sqrt(1 - sin(x).pow(2))
    } else {
        -sqrt(1 - sin(x).pow(2))
    }

    override fun ln(x: Double): Double {
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

        /*
        while (value < 1.0) {
            value *= Math.E
            iters--
        }
        */

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

object BasicFunStub : IBasicFun{
    private val sinTable = mapOf(
        Math.PI / 6 to 0.5,
        Math.PI / 4 to 0.70710678,
        Math.PI / 2 to 1.0,
        Math.PI to 0.0,
        -Math.PI / 2 to -1.0
    )
    private val cosTable = mapOf(
        0.0 to 1.0,
        Math.PI / 6 to 0.8660254,
        Math.PI / 4 to 0.70710678,
        Math.PI / 2 to 0.0,
        Math.PI to -1.0,
        -Math.PI / 2 to 0.0
    )

    private val lnTable = mapOf(
        1.0 to 0.0,
        Math.E to 1.0,
        10.0 to 2.302585,
        0.5 to -0.693147
    )

    override fun sin(x: Double): Double =
        sinTable[x] ?: throw IllegalArgumentException("Value $x not in sin stub table")

    override fun cos(x: Double): Double =
        cosTable[x] ?: throw IllegalArgumentException("Value $x not in cos stub table")

    override fun ln(x: Double): Double =
        lnTable[x] ?: throw IllegalArgumentException("Value $x not in ln stub table")
}