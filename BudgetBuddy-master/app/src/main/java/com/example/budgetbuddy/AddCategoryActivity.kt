class AddCategoryActivity : AppCompatActivity() {

    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_category)

        db = AppDatabase.getDatabase(this)

        val name = findViewById<EditText>(R.id.etName)
        val min = findViewById<EditText>(R.id.etMin)
        val max = findViewById<EditText>(R.id.etMax)
        val limit = findViewById<EditText>(R.id.etLimit)
        val btnSave = findViewById<Button>(R.id.btnSave)

        btnSave.setOnClickListener {

            val nameText = name.text.toString()
            val minText = min.text.toString()
            val maxText = max.text.toString()

            // Input Validation
            if (nameText.isEmpty()) {
                name.error = "Required"
                return@setOnClickListener
            }

            if (minText.isEmpty() || maxText.isEmpty()) {
                Toast.makeText(this, "Enter budgets", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val minVal = minText.toDouble()
            val maxVal = maxText.toDouble()

            if (minVal > maxVal) {
                Toast.makeText(this, "Min > Max", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val limitVal = if (limit.text.isNotEmpty()) limit.text.toString().toDouble() else null

            val category = Category(
                name = nameText,
                minBudget = minVal,
                maxBudget = maxVal,
                limit = limitVal
            )

            // Room requires background thread to save
            lifecycleScope.launch {
                db.categoryDao().insert(category)

                runOnUiThread {
                    Toast.makeText(this@AddCategoryActivity, "Saved!", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }
    }
}