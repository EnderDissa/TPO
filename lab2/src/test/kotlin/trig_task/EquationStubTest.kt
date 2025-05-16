package trig_task

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class EquationStubTest {
    private val delta = 1e-6

    @Test
    fun testFirstPartWithStub() {
        val x = Math.PI / 6
        val result = EquationSingletonStub.getResult(x = -x) // x <= 0
        println("Result for x=$x (firstPart): $result")
    }

    @Test
    fun testSecondPartWithStub() {
        val x = 5.0
        val result = EquationSingletonStub.getResult(x) // x > 0
        println("Result for x=$x (secondPart): $result")
        assertEquals(0.0, result, delta)
    }

    @Test
    fun testSecondPartException() {
        val x = 1.0
        assertFailsWith<IllegalArgumentException> {
            EquationSingletonStub.getResult(x)
        }
    }
}