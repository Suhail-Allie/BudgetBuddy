package com.example.budgetbuddy.ui.expense

import android.net.Uri
import android.view.*
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.budgetbuddy.R
import com.example.budgetbuddy.data.Expense

class ExpenseAdapter(private val list: List<Expense>) :
    RecyclerView.Adapter<ExpenseAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val amount: TextView = view.findViewById(R.id.tvAmount)
        val date: TextView = view.findViewById(R.id.tvDate)
        val category: TextView = view.findViewById(R.id.tvCategory)
        val desc: TextView = view.findViewById(R.id.tvDescription)
        val image: ImageView = view.findViewById(R.id.imgReceipt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_expense, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val expense = list[position]

        holder.amount.text = "R ${expense.amount}"
        holder.date.text = expense.date
        holder.category.text = expense.category
        holder.desc.text = expense.description

        if (expense.imageUri != null) {
            holder.image.setImageURI(Uri.parse(expense.imageUri))
        }
    }
}
