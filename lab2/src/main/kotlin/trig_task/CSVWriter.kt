package trig_task

import java.io.FileWriter

class CSVWriter(
    private val writeDir: String,
    private val delimiter: Char,
    private val lineEnd: Char
) {
    fun writeData(
        fileName: String,
        startValue: Double,
        endValue: Double,
        numberOfRows: Int,
        function: (Double) -> Double
    ) {
        if (fileName.isEmpty()) return
        val fileWriter = FileWriter(writeDir + fileName)

        val step = (endValue - startValue) / numberOfRows
        fileWriter.write("argument" + delimiter + "result" + lineEnd)
        for (i in 1..numberOfRows) {
            fileWriter.write("" + (startValue + step * i) + delimiter + function(startValue + step * i) + lineEnd)
        }

        fileWriter.close()
    }
}