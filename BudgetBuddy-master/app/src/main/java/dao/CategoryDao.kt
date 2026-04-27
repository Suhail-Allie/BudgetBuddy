package com.example.budgettracker.data.dao

@Dao
interface CategoryDao {

    @Insert
    suspend fun insert(category: Category)

    @Query("SELECT * FROM categories")
    suspend fun getAllCategories(): List<Category>

    @Delete
    suspend fun delete(category: Category)
}