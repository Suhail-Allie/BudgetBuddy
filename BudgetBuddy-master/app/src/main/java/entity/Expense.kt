package com.example.budgettracker.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expenses")
data class Expense(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val amount: Double,
    val categoryId: Int,
    val description: String,
    val date: Long,
    val startTime: String,
    val endTime: String,
    val imageUri: String?
)