package first_task.utils

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.concurrent.ThreadLocalRandom
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import kotlin.random.Random

class TrigonometricTest {
    @Test
    @DisplayName("Test sec for known values")
    fun testSecForKnownValues() {
        val testCases = listOf(
            Pair(0.0, 1.0),
            Pair(Math.PI, -1.0),
            Pair(2 * Math.PI, 1.0)
        )

        testCases.forEach { (angle, expected) ->
            val actual = TrigFuncs.sec(angle)
            assertEquals(expected, actual, 0.0001, "Expected sec($angle) to be $expected, but got $actual")
        }
    }

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
        Double.MIN_VALUE,
        -Double.MIN_VALUE
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

    @ParameterizedTest(name = "sec({0}) = {1}")
    @DisplayName("Check from table")
    @CsvFileSource(resources = ["/table_values.csv"], numLinesToSkip = 1, delimiter = ';')
    fun checkFromTable(x: Double, y: Double) {
        val actual = TrigFuncs.sec(x)
        assertEquals(y, actual, 0.1, "Failed for input: $x. Expected value from table: $y. Actual sec($x) = $actual")
    }

    @Test
    @DisplayName("Random angles sec test")
    fun testSecForRandomAngles() {
        repeat(10) {
            val randomAngle = Random.nextDouble(-Math.PI, Math.PI)

            val actual = TrigFuncs.sec(randomAngle)
            val expected = 1 / Math.cos(randomAngle)

            println("Testing sec($randomAngle): Expected = $expected, Actual = $actual")
            assertEquals(expected, actual, 0.01, "Failed for sec($randomAngle). Expected: $expected, but got: $actual")
        }
    }
}