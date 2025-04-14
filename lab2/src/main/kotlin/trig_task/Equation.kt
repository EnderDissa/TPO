package trig_task

import trig_task.math.*
import kotlin.math.abs
import kotlin.math.pow

object Equation {
    private fun firstPart(x: Double): Double {
        val r1 = ComplexFun.tan(x) + ComplexFun.sec(x) + BasicFun.sin(x)
        val r2 = (ComplexFun.csc(x) * ComplexFun.tan(x)).pow(2)

        return r1 + r2
    }

    private fun secondPart(x: Double): Double {
        if (abs(ComplexFun.log5(x)) <= 1e-10) throw IllegalArgumentException("log5(x) must have non zero value")

        val r1 = ComplexFun.log5(x) / ComplexFun.log5(x)
        val r2 = (r1 - BasicFun.ln(x)).pow(3)

        val r3 = (ComplexFun.log10(x) - ComplexFun.log10(x)).pow(3)

        return r2 * r3
    }

    fun getResult(x: Double) = if (x <= 0) {
        firstPart(x)
    } else {
        secondPart(x)
    }
}