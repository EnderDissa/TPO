package trig_task.math

import kotlin.math.abs

object ComplexFun {
    fun log5(x: Double) = BasicFun.ln(x) / BasicFun.ln(5.0)

    fun log10(x: Double) = BasicFun.ln(x) / BasicFun.ln(10.0)

    fun tan(x: Double) = if (abs(BasicFun.cos(x)) >= 1e-10) {
        BasicFun.sin(x) / BasicFun.cos(x)
    } else {
        throw IllegalArgumentException("Value must have non zero cos")
    }

    fun sec(x: Double) = if (abs(BasicFun.cos(x)) >= 1e-10) {
        1 / BasicFun.cos(x)
    } else {
        throw IllegalArgumentException("Value must have non zero cos")
    }

    fun csc(x: Double) = if (abs(BasicFun.sin(x)) >= 1e-10) {
        1 / BasicFun.sin(x)
    } else {
        throw IllegalArgumentException("Value must have non zero sin")
    }
}
