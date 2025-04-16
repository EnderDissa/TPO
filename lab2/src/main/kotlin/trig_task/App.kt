package trig_task

fun main() {
    println("Equation(3e)=" + Equation.getResult(1.98))
    try {
        println("Equation(-3e)=" + Equation.getResult(-3 * Math.E))
    }
    catch (e: Exception) {
        println("Caught exception " + e.message)
    }

    val csvWriter = CSVWriter(
        "./",
        ';',
        '\n'
    )

    csvWriter.writeData("new.csv", startValue = 1.0, endValue = 3.0, numberOfRows = 100, Equation::getResult)
}