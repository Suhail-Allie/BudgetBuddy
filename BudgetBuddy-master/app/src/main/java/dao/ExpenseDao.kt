package com.example.budgettracker.data.dao

import androidx.room.*
import com.example.budgettracker.data.entity.Expense

@Dao
interface ExpenseDao {

    @Insert
    suspend fun insertExpense(expense: Expense)

    @Query("SELECT * FROM expenses")
    suspend fun getAllExpenses(): List<Expense>

    @Query("SELECT * FROM expenses WHERE date BETWEEN :startDate AND :endDate")
    suspend fun getExpensesByDate(startDate: Long, endDate: Long): List<Expense>

    @Query("""
        SELECT categoryId, SUM(amount) as total 
        FROM expenses 
        WHERE date BETWEEN :startDate AND :endDate 
        GROUP BY categoryId
    """)
    suspend fun getCategoryTotals(startDate: Long, endDate: Long): List<CategoryTotal>
}