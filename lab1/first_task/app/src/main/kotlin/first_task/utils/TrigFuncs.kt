package first_task.utils

object TrigFuncs {
    fun sec(x: Double): Double {
        return secTaylor(x, Int.MAX_VALUE)
    }

    fun secTaylor(x: Double, terms: Int): Double {
        var result = 1.0
        var fact = 1.0

        if (x != 0.0 && x / Math.PI - (x / Math.PI).toInt() < 0.000001) {
            return 0.0
        }
        
        for (n in 1 until terms) {
            fact *= -1 * x * x / (2 * n) / (2 * n - 1)
            result += fact
        }

        return 1 / result
    }
}