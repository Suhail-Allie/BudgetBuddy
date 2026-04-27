package com.example.budgetbuddy.ui.expense

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.budgetbuddy.R
import com.example.budgetbuddy.data.AppDatabase

class ViewExpensesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_expenses)

        val recycler = findViewById<RecyclerView>(R.id.recyclerExpenses)
        recycler.layoutManager = LinearLayoutManager(this)

        AppDatabase.getDatabase(this)
            .expenseDao()
            .getAllExpenses()
            .observe(this) { list ->
                Log.d("ExpenseList", "Loaded ${list.size} expenses")
                recycler.adapter = ExpenseAdapter(list)
            }
    }
}
