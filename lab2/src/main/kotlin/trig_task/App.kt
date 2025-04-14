package trig_task

fun main() {
    println("Equation(3e)=" + Equation.getResult(3 * Math.E))
    try {
        println("Equation(-3e)=" + Equation.getResult(-3 * Math.E))
    }
    catch (e: Exception) {
        println("Caught exception " + e.message)
    }
}