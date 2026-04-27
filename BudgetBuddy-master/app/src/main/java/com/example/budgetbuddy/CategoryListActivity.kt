class CategoryListActivity : AppCompatActivity() {

    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_list)

        db = AppDatabase.getDatabase(this)

        val recycler = findViewById<RecyclerView>(R.id.recyclerView)

        lifecycleScope.launch {
            val categories = db.categoryDao().getAllCategories()

            runOnUiThread {
                recycler.layoutManager = LinearLayoutManager(this@CategoryListActivity)
                recycler.adapter = CategoryAdapter(categories)
            }
        }
    }
}
// to reload categories
override fun onResume() {
    super.onResume()
}