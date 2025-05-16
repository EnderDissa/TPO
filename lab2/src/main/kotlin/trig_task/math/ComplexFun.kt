package trig_task.math

import trig_task.IComplexFun
import kotlin.math.abs

object ComplexFun : IComplexFun{
    override fun log5(x: Double) = BasicFun.ln(x) / BasicFun.ln(5.0)

    override fun log10(x: Double) = BasicFun.ln(x) / BasicFun.ln(10.0)

    override fun tan(x: Double) = if (abs(BasicFun.cos(x)) >= 1e-10) {
        BasicFun.sin(x) / BasicFun.cos(x)
    } else {
        throw IllegalArgumentException("Value must have non zero cos")
    }

    override fun sec(x: Double) = if (abs(BasicFun.cos(x)) >= 1e-10) {
        1 / BasicFun.cos(x)
    } else {
        throw IllegalArgumentException("Value must have non zero cos")
    }

    override fun csc(x: Double) = if (abs(BasicFun.sin(x)) >= 1e-10) {
        1 / BasicFun.sin(x)
    } else {
        throw IllegalArgumentException("Value must have non zero sin")
    }
}

object ComplexFunStub : IComplexFun{
    private val tanTable = mapOf(
        0.0 to 0.0,
        Math.PI / 6 to 0.577350269,
        Math.PI / 4 to 1.0,
        Math.PI / 3 to 1.732050807,
        Math.PI / 2 to Double.POSITIVE_INFINITY
    )

    private val secTable = mapOf(
        0.0 to 1.0,
        Math.PI / 6 to 1.154700538,
        Math.PI / 4 to 1.414213562,
        Math.PI / 3 to 2.0,
        Math.PI / 2 to Double.POSITIVE_INFINITY
    )

    private val cscTable = mapOf(
        Math.PI / 6 to 2.0,
        Math.PI / 4 to 1.414213562,
        Math.PI / 3 to 1.154700538,
        Math.PI / 2 to 1.0
    )

    private val log5Table = mapOf(
        1.0 to 0.0,
        5.0 to 1.0,
        25.0 to 2.0
    )

    private val log10Table = mapOf(
        1.0 to 0.0,
        10.0 to 1.0,
        100.0 to 2.0
    )

    override fun tan(x: Double): Double =
        tanTable[x] ?: throw IllegalArgumentException("Value $x not in tan stub table")

    override fun sec(x: Double): Double =
        secTable[x] ?: throw IllegalArgumentException("Value $x not in sec stub table")

    override fun csc(x: Double): Double =
        cscTable[x] ?: throw IllegalArgumentException("Value $x not in csc stub table")

    override fun log5(x: Double): Double =
        log5Table[x] ?: throw IllegalArgumentException("Value $x not in log5 stub table")

    override fun log10(x: Double): Double =
        log10Table[x] ?: throw IllegalArgumentException("Value $x not in log10 stub table")
}
