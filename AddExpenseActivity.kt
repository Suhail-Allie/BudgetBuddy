package com.example.budgetbuddy.ui.expense

import android.app.*
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.budgetbuddy.R
import com.example.budgetbuddy.data.*
import kotlinx.coroutines.*

class AddExpenseActivity : AppCompatActivity() {

    private lateinit var imgReceipt: ImageView
    private var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_expense)

        val etAmount = findViewById<EditText>(R.id.etAmount)
        val etDate = findViewById<EditText>(R.id.etDate)
        val etStart = findViewById<EditText>(R.id.etStartTime)
        val etEnd = findViewById<EditText>(R.id.etEndTime)
        val etDesc = findViewById<EditText>(R.id.etDescription)
        val spinner = findViewById<Spinner>(R.id.spCategory)
        imgReceipt = findViewById(R.id.imgReceipt)

        val btnUpload = findViewById<Button>(R.id.btnUpload)
        val btnSave = findViewById<Button>(R.id.btnSave)

        btnUpload.setOnClickListener { pickImageFromGallery() }

        btnSave.setOnClickListener {
            val amount = etAmount.text.toString()
            val date = etDate.text.toString()
            val start = etStart.text.toString()
            val end = etEnd.text.toString()
            val desc = etDesc.text.toString()
            val category = spinner.selectedItem.toString()

            if (amount.isEmpty() || date.isEmpty() || start.isEmpty() ||
                end.isEmpty() || desc.isEmpty()) {
                Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val expense = Expense(
                amount = amount.toDouble(),
                date = date,
                startTime = start,
                endTime = end,
                description = desc,
                category = category,
                imageUri = imageUri?.toString()
            )

            CoroutineScope(Dispatchers.IO).launch {
                AppDatabase.getDatabase(this@AddExpenseActivity)
                    .expenseDao()
                    .insertExpense(expense)

                Log.d("ExpenseLog", "Saved")

                runOnUiThread {
                    Toast.makeText(this@AddExpenseActivity, "Saved!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun pickImageFromGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, 100)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == RESULT_OK) {
            imageUri = data?.data
            imgReceipt.setImageURI(imageUri)
        }
    }
}
