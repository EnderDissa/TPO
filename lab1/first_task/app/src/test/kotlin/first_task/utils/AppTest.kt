package first_task.utils

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.concurrent.ThreadLocalRandom
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertEquals

class TrigonometricTest {

    @ParameterizedTest(name = "sec({0})")
    @DisplayName("Check corner values")
    @ValueSource(doubles = [
        -999.9,
        -1.0000001,
        -1.0,
        -0.99,
        -0.5,
        -0.000001,
        -0.0001,
        -0.0,
        0.0,
        0.0001,
        0.000001,
        0.5,
        0.99,
        1.0,
        1.0000001,
        999.9,
        Double.NaN,
        Double.POSITIVE_INFINITY,
        Double.MIN_VALUE
    ])
    fun checkCornerDots(param: Double) {
        val expected = try {
            1.0 / Math.cos(param)
        } catch (e: ArithmeticException) {
            Double.NaN
        }
        
        val actual = try {
            TrigFuncs.sec(param)
        } catch (e: Exception) {
            e.printStackTrace()
            throw e
        }

        assertAll(
            { 
                assertEquals(expected, actual, 0.1)
            }
        )
    }

    /*

    @ParameterizedTest(name = "sec({0}) = {1}")
    @DisplayName("Check between dots [-1; +1]")
    @CsvFileSource(resources = ["/table_values.csv"], numLinesToSkip = 1, delimiter = ';')
    fun checkBetweenDotsMinus1And1(x: Double, y: Double) {
        val actual = TrigFuncs.sec(x)
        assertAll(
            { assertEquals(y, actual, 0.0001) {
                """
                Failed for input: $x
                Expected value from table: $y
                Actual sec($x) = $actual
                Delta allowed: 0.0001
                """.trimIndent()
            } }
        )
    }

    @Test
    @DisplayName("Fuzzy testing")
    fun checkRandomDots() {
        val failedCases = mutableListOf<String>()
        
        for (i in 0 until 1_000_000) {
            val randomValue = ThreadLocalRandom.current().nextDouble(-0.9999, 0.9999)
            val expected = 1.0 / Math.cos(randomValue)
            val actual = TrigFuncs.sec(randomValue)
            
            try {
                assertEquals(expected, actual, 0.0001)
            } catch (e: AssertionError) {
                failedCases.add("""
                    |Failed for random value: $randomValue
                    |Expected sec($randomValue) = $expected
                    |Actual sec($randomValue) = $actual
                    |Delta allowed: 0.0001
                    |Difference: ${Math.abs(expected - actual)}
                    """.trimMargin())
                if (failedCases.size >= 10) break // Ограничим количество сохраняемых ошибок
            }
        }

        if (failedCases.isNotEmpty()) {
            throw AssertionError("""
                |Fuzzy testing failed with ${failedCases.size} cases.
                |First ${failedCases.size.coerceAtMost(10)} failures:
                |${failedCases.joinToString("\n|")}
                """.trimMargin())
        }
    }
    */
}