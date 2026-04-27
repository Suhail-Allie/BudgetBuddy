package com.example.budgetbuddy

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tvWelcomeUser: TextView
    private lateinit var tvBalance: TextView
    private lateinit var etAmount: EditText
    private lateinit var btnAddIncome: Button
    private lateinit var btnAddExpense: Button
    private lateinit var btnClearHistory: Button
    private lateinit var btnLogout: Button
    private lateinit var tvTransactions: TextView

    private var balance = 0.0
    private var transactionHistory = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI components
        tvWelcomeUser = findViewById(R.id.tvWelcomeUser)
        tvBalance = findViewById(R.id.tvBalance)
        etAmount = findViewById(R.id.etAmount)
        btnAddIncome = findViewById(R.id.btnAddIncome)
        btnAddExpense = findViewById(R.id.btnAddExpense)
        btnClearHistory = findViewById(R.id.btnClearHistory)
        btnLogout = findViewById(R.id.btnLogout)
        tvTransactions = findViewById(R.id.tvTransactions)

        // Load saved user data, balance and transaction history
        val sharedPref = getSharedPreferences("UserData", MODE_PRIVATE)
        val username = sharedPref.getString("username", "User")

        balance = sharedPref.getFloat("balance", 0f).toDouble()
        transactionHistory = sharedPref.getString("transactions", "") ?: ""

        tvWelcomeUser.text = "Welcome, $username"
        updateBalance()
        updateTransactionText()

        Log.d("Dashboard", "Dashboard opened for user: $username")

        // Add income to balance and update history
        btnAddIncome.setOnClickListener {
            val amount = etAmount.text.toString().toDoubleOrNull()

            if (amount == null || amount <= 0) {
                Toast.makeText(this, "Enter a valid amount greater than 0", Toast.LENGTH_SHORT).show()
                Log.d("Finance", "Invalid income amount entered")
                return@setOnClickListener
            }

            balance += amount

            val transaction = "+ R%.2f Income".format(amount)
            transactionHistory = if (transactionHistory.isEmpty()) {
                transaction
            } else {
                "$transactionHistory\n$transaction"
            }

            saveData()
            updateBalance()
            updateTransactionText()
            etAmount.text.clear()

            Log.d("Finance", "Income added: $amount")
        }

        // Deduct expense from balance and update history
        btnAddExpense.setOnClickListener {
            val amount = etAmount.text.toString().toDoubleOrNull()

            if (amount == null || amount <= 0) {
                Toast.makeText(this, "Enter a valid amount greater than 0", Toast.LENGTH_SHORT).show()
                Log.d("Finance", "Invalid expense amount entered")
                return@setOnClickListener
            }

            balance -= amount

            val transaction = "- R%.2f Expense".format(amount)
            transactionHistory = if (transactionHistory.isEmpty()) {
                transaction
            } else {
                "$transactionHistory\n$transaction"
            }

            saveData()
            updateBalance()
            updateTransactionText()
            etAmount.text.clear()

            Log.d("Finance", "Expense added: $amount")
        }
        btnCatergories.setOnClickListener {
            startActivity(Intent(this, CatergoryListACtivity::class.java))
        }
        btnAddCategory.setOnClickListener {
            startActivity(Intent(this, AddCategoryActivity::class.java))
        }

        // Clear transaction history
        btnClearHistory.setOnClickListener {
            transactionHistory = ""
            saveData()
            updateTransactionText()
            Toast.makeText(this, "Transaction history cleared", Toast.LENGTH_SHORT).show()

            Log.d("Finance", "Transaction history cleared")
        }

        // Logout and return to login screen
        btnLogout.setOnClickListener {
            Log.d("Dashboard", "User logged out")

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    // Update balance text on dashboard
    private fun updateBalance() {
        tvBalance.text = "Balance: R%.2f".format(balance)
    }

    // Update transaction history text
    private fun updateTransactionText() {
        if (transactionHistory.isEmpty()) {
            tvTransactions.text = "No transactions yet"
        } else {
            tvTransactions.text = transactionHistory
        }
    }

    // Save updated balance and transaction history
    private fun saveData() {
        val sharedPref = getSharedPreferences("UserData", MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putFloat("balance", balance.toFloat())
        editor.putString("transactions", transactionHistory)
        editor.apply()
    }
}