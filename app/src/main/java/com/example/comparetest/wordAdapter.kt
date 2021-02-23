package com.example.comparetest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.comparetest.db.Word

class wordAdapter(
    private val context: Context,
    private val list: List<Word>
): RecyclerView.Adapter<wordAdapter.ViewHolder>() {

    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val text : TextView = view.findViewById(android.R.id.text1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val View = View.inflate(parent.context, android.R.layout.simple_list_item_1, null)
        return ViewHolder(View)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.text.text = list[position].word
    }

    override fun getItemCount(): Int = list.size
}