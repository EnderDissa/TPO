package trig_task

import trig_task.math.BasicFun

fun main() {
    println("sin(0)=" + BasicFun.sin(.0))
    println("sin(PI)=" + BasicFun.sin(Math.PI))
    println("sin(PI / 2)=" + BasicFun.sin(Math.PI / 2))
    println("sin(-PI / 2)=" + BasicFun.sin(-Math.PI / 2))
    println("sin(0)=" + BasicFun.sin(.0))

    try {
        println("ln(0)=" + BasicFun.ln(.0))
    }
    catch (e: Exception) {
        println("Caught exception " + e.message)
    }
    println("ln(1)=" + BasicFun.ln(1.0))
    println("ln(e)=" + BasicFun.ln(Math.E))
    println("ln(3e)=" + BasicFun.ln(3 * Math.E))
}