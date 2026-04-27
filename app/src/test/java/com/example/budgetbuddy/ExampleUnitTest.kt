package com.example.budgetbuddy

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * Updated test
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}
@Test
fun expenseCalculation_isCorrect(): Unit {
    val total = 100 + 250
    assertEquals(350, total)
}