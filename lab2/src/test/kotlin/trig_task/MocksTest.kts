package trig_task

import io.mockk.every
import io.mockk.mockk
import kotlin.test.Test
import kotlin.test.assertEquals

class MocksTest {
    private val delta = 1e-6

    @Test
    fun `firstPart(x) для x меньше либо равно нуля — проверяем через мок`() {
        val basicMock = mockk<BasicFunctions>()
        val complexMock = mockk<ComplexFunctions>()

        val x = -Math.PI / 6

        every { complexMock.tan(x) } returns -0.57735027
        every { complexMock.sec(x) } returns 1.1547005
        every { basicMock.sin(x) } returns -0.5
        every { complexMock.csc(x) } returns -2.0

        val equation = Equation(basicMock, complexMock)

        val expectedR1 = -0.57735027 + 1.1547005 + (-0.5)
        val expectedR2 = ((-2.0) * (-0.57735027)).pow(2)
        val expectedSum = expectedR1 + expectedR2

        val result = equation.getResult(x)
        assertEquals(expectedSum, result, delta)
    }

    @Test
    fun `secondPart(x) для x > 0 & log5(x) ≠ 0 — вычисляем через мок`() {
        val basicMock = mockk<BasicFunctions>()
        val complexMock = mockk<ComplexFunctions>()

        val x = 5.0

        every { complexMock.log5(x) } returns 1.0
        every { basicMock.ln(x) } returns 1.6
        every { complexMock.log10(x) } returns 0.7
        val equation = Equation(basicMock, complexMock)

        val expected = 0.0

        val result = equation.getResult(x)
        assertEquals(expected, result, delta)
    }

    @Test
    fun `secondPart(x) для x > 0 & log5(x) == 0 — кидает IllegalArgumentException`() {
        val basicMock = mockk<BasicFunctions>()
        val complexMock = mockk<ComplexFunctions>()

        val x = 1.0


        every { complexMock.log5(x) } returns 0.0
        every { basicMock.ln(x) } returns 0.0
        every { complexMock.log10(x) } returns 0.0

        val equation = Equation(basicMock, complexMock)

        assertFailsWith<IllegalArgumentException> {
            equation.getResult(x)
        }
    }
}