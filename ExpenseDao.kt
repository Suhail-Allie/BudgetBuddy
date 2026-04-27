package com.example.budgetbuddy.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ExpenseDao {

    @Insert
    suspend fun insertExpense(expense: Expense)

    @Query("SELECT * FROM expenses")
    fun getAllExpenses(): LiveData<List<Expense>>
}
