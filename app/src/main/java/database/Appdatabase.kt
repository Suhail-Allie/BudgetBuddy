package com.example.budgettracker.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.budgettracker.data.entity.Expense
import com.example.budgettracker.data.entity.Category
import com.example.budgettracker.data.dao.ExpenseDao

@Database(entities = [Expense::class, Category::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun expenseDao(): ExpenseDao
}