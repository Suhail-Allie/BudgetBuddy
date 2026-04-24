package com.example.budgettracker

import com.example.budgettracker.data.entity.Expense
import org.junit.Test

import org.junit.Assert.*

private val ExampleUnitTest.lifecycleScope: Any
    get() {
        TODO()
    }

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)

        lifecycleScope.launch {
            expenseDao.insertExpense(
                Expense(
                    amount = 200.0,
                    categoryId = 1,
                    description = "Test Expense",
                    date = System.currentTimeMillis(),
                    startTime = "12:00",
                    endTime = "13:00",
                    imageUri = null
                )
            )
        }
    }
}