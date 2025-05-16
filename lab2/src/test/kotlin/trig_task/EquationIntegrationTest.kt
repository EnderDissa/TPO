package trig_task

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue
import trig_task.EquationSingleton
import trig_task.EquationSingletonStub

class EquationIntegrationTest {
    private val delta = 1e-6
    @Test
    fun testFirstPartWithRealImplementations() {
        val x = Math.PI / 6
        val result = EquationSingleton.getResult(-x)
        println("Integration test result for x=$x (firstPart): $result")
        assertTrue(result.isFinite() && result > 0)
    }

    @Test
    fun testSecondPartWithRealImplementations() {
        val x = 5.0
        val result = EquationSingleton.getResult(x)
        println("Integration test result for x=$x (secondPart): $result")
        assertTrue(result.isFinite())
    }

    @Test
    fun testExceptionWithRealImplementations() {
        val x = 1.0
        assertFailsWith<IllegalArgumentException> {
            EquationSingleton.getResult(x)
        }
    }

    @Test
    fun testFirstPartWithStubImplementations() {
        val x = Math.PI / 4
        val result = EquationSingletonStub.getResult(-x)
        println("Stub integration test result for x=$x (firstPart): $result")
    }

    @Test
    fun testSecondPartWithStubImplementations() {
        val x = 25.0
        val result = EquationSingletonStub.getResult(x)
        println("Stub integration test result for x=$x (secondPart): $result")
        assertTrue(result.isFinite())
    }

    @Test
    fun testExceptionWithStubImplementations() {
        val x = 1.0
        assertFailsWith<IllegalArgumentException> {
            EquationSingletonStub.getResult(x)
        }
    }


    @Test
    fun testLargeNegativeInput() {
        val x = -1e6
        val result = EquationSingleton.getResult(x)
        println("Integration test with large negative x=$x: $result")
        assertTrue(result.isFinite())
    }

    @Test
    fun testLargePositiveInput() {
        val x = 1e6
        val result = EquationSingleton.getResult(x)
        println("Integration test with large positive x=$x: $result")
        assertTrue(result.isFinite())
    }
}