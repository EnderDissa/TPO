package first_task.utils

import kotlin.math.PI
import kotlin.math.floor
import kotlin.math.abs 

object TrigFuncs {
    fun sec(x: Double): Double {
        return secTaylor(x, Int.MAX_VALUE)
    }

    fun secTaylor(x1: Double, terms: Int): Double {
        var result = 1.0
        var fact = 1.0

        var x = normalizeAngleToZeroPi(abs(x1))
        if (x - PI / 2 < 0.00001 && x - PI / 2 > -0.00001) {
            return Double.MAX_VALUE
        }


        for (n in 1 until terms) {
            fact *= -1 * x * x / (2 * n) / (2 * n - 1)
            result += fact
        }
        return 1 / result
    }

    fun normalizeAngleToZeroPi(angle: Double): Double {
        val normalized2Pi = angle - 2 * PI * floor(angle / (2 * PI))
        
        return if (normalized2Pi > PI) 2 * PI - normalized2Pi else normalized2Pi
    }
}